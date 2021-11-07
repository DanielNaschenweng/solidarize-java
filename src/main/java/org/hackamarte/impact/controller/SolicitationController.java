package org.hackamarte.impact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.impact.model.Solicitation;
import org.hackamarte.impact.service.SolicitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/solicitation")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SolicitationController {
    @Autowired
    private SolicitationService service;

    @GetMapping(path = "/{id}")
    public Solicitation get(@PathVariable("id") String id){
        return service.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody Solicitation solicitation){
        solicitation =  service.create(solicitation);
        return ResponseEntity.created(URI.create("/solicitation/"+solicitation.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody Solicitation solicitation){
        service.update(solicitation);
        return ResponseEntity.ok("Solicitação alterada com sucesso!");
    }
}
