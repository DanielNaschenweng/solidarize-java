package org.hackamarte.solidarize.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hackamarte.solidarize.model.Category;
import org.hackamarte.solidarize.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/category")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping(path = "/{id}")
    public Category get(@PathVariable("id") String id){
        return service.find(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@Valid @RequestBody Category categoryModel){
        Category category =  service.create(categoryModel);
        return ResponseEntity.created(URI.create("/category/"+category.getId().toString())).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody Category category){
        service.update(category);
        return ResponseEntity.ok("Categoria alterada com sucesso!");
    }
}
