package org.hackamarte.impact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.User;
import org.hackamarte.impact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "login/{login}")
    public User findByLogin(@PathVariable("login") String login) {
        return userService.findByLogin(login)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado com login: "+login));
    }

    @GetMapping(path = "/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody User User) {

        if (userService.findByLogin(User.getLogin()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND,"Já existe um usuário com o login: "+User.getLogin());
        }
        User = userService.update(User);
        return ResponseEntity.created(URI.create("/user/"+User.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody User UserModel) {
        userService.update(UserModel);
        return ResponseEntity.ok("Usuário alterado com sucesso!");
    }

}
