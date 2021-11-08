package org.hackamarte.solidarize.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.solidarize.exception.NotFoundException;
import org.hackamarte.solidarize.model.Person;
import org.hackamarte.solidarize.service.PersonService;
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
@RequestMapping(value = "/person")
@RequiredArgsConstructor
@Slf4j
@Validated
public class PersonController {

    @Autowired
    final private PersonService personService;

    @GetMapping(path = "/{id}")
    public Person findById(@PathVariable("id") String id) {
        return personService.findById(UUID.fromString(id));
    }

    @GetMapping(path = "cpf/{cpf}")
    public Person getByCpf(@PathVariable("cpf") String cpf) {
        return personService.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com CPF: "+cpf));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody Person person) {

        if (personService.findByCpf(person.getCpf()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND,"Já existe uma pessoa com o CPF: "+person.getCpf());
        }
        person = personService.update(person);
        return ResponseEntity.created(URI.create("/person/"+person.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody Person personModel) {
        personService.update(personModel);
        return ResponseEntity.ok("Pessoa alterada com sucesso!");
    }

}
