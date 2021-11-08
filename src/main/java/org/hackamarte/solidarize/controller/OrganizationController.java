package org.hackamarte.solidarize.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.solidarize.model.Organization;
import org.hackamarte.solidarize.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/organization")
@RequiredArgsConstructor
@Slf4j
@Validated
public class OrganizationController {
    @Autowired
    private OrganizationService service;

    @GetMapping(path = "/{id}")
    public Organization get(@PathVariable("id") String id){
        return service.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody Organization organization){
        organization =  service.create(organization);
        return ResponseEntity.created(URI.create("/organization/"+organization.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody Organization organization){
        service.update(organization);
        return ResponseEntity.ok("Organizationm alterada com sucesso!");
    }
}
