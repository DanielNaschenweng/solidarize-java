package org.hackamarte.impact.service;

import lombok.NoArgsConstructor;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.IntentionOfGiver;
import org.hackamarte.impact.repository.IntentionOfGiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class IntentionOfGiverService {

    @Autowired
    private IntentionOfGiverRepository IntentionOfGiverRepository;

    public IntentionOfGiver find(UUID id) {
        return IntentionOfGiverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Intenção de Doação não encontrada com ID: "+id));
    }

    public IntentionOfGiver create(IntentionOfGiver IntentionOfGiver) {
        return IntentionOfGiverRepository.save(IntentionOfGiver);
    }

    public IntentionOfGiver update(IntentionOfGiver IntentionOfGiver) {
        return IntentionOfGiverRepository.save(IntentionOfGiver);
    }
    
    
}
