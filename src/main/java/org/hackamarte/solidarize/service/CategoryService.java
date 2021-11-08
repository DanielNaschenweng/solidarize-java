package org.hackamarte.solidarize.service;

import lombok.NoArgsConstructor;
import org.hackamarte.solidarize.exception.NotFoundException;
import org.hackamarte.solidarize.model.Category;
import org.hackamarte.solidarize.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class CategoryService {

    @Autowired
    private org.hackamarte.solidarize.repository.CategoryRepository CategoryRepository;

    public Category find(UUID id) {
        return CategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada com ID: "+id));
    }

    public Category create(Category Category) {
        return CategoryRepository.save(Category);
    }

    public Category update(Category Category) {
        return CategoryRepository.save(Category);
    }

}
