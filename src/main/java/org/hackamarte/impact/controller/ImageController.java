package org.hackamarte.impact.controller;

import org.hackamarte.impact.model.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.impact.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/image")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping(path = "/{id}")
    public Image get(@PathVariable("id") String id){
        return service.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody Image image){
        image =  service.create(image);
        return ResponseEntity.created(URI.create("/image/"+image.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody Image image){
        service.update(image);
        return ResponseEntity.ok("Imagem alterada com sucesso!");
    }

}
