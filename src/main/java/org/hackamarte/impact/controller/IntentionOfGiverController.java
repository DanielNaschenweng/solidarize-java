package org.hackamarte.impact.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.impact.model.IntentionOfGiver;
import org.hackamarte.impact.service.IntentionOfGiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/intentionofgiver")
@RequiredArgsConstructor
@Slf4j
@Validated
public class IntentionOfGiverController {

    @Autowired
    IntentionOfGiverService intentionOfGiverService;

    @GetMapping(path = "/{id}")
    public IntentionOfGiver get(@PathVariable("id") String id){
        return intentionOfGiverService.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody IntentionOfGiver intentionOfGiver){
        intentionOfGiver = intentionOfGiverService.create(intentionOfGiver);
        return ResponseEntity.created(URI.create("/intentionofgiver/"+intentionOfGiver.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody IntentionOfGiver intentionOfGiver){
        intentionOfGiverService.update(intentionOfGiver);
        return ResponseEntity.ok("Intenção de doação alterada com sucesso!");
    }



}
