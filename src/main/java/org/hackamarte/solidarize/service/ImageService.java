package org.hackamarte.solidarize.service;

import lombok.NoArgsConstructor;
import org.hackamarte.solidarize.exception.NotFoundException;
import org.hackamarte.solidarize.model.Image;
import org.hackamarte.solidarize.repository.ImageRepository;
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
