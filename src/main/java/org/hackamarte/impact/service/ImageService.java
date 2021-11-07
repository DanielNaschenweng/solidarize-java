package org.hackamarte.impact.service;

import lombok.NoArgsConstructor;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.Image;
import org.hackamarte.impact.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image find(UUID id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Imagem não encontrado com ID: "+id));
    }

    public Image create(Image image) {

        return imageRepository.save(image);
    }

    public Image update(Image image) {
        return imageRepository.save(image);
    }


}
