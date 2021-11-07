package org.hackamarte.impact.service;

import lombok.NoArgsConstructor;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.Solicitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class SolicitationService {

    @Autowired
    private org.hackamarte.impact.repository.SolicitationRepository SolicitationRepository;

    public Solicitation find(UUID id) {
        return SolicitationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Colicitação de Doação não encontrada com ID: "+id));
    }

    public Solicitation create(Solicitation Solicitation) {
        return SolicitationRepository.save(Solicitation);
    }

    public Solicitation update(Solicitation Solicitation) {
        return SolicitationRepository.save(Solicitation);
    }
    
}
