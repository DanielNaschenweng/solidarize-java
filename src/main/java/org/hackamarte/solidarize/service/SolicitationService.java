package org.hackamarte.solidarize.service;

import lombok.NoArgsConstructor;
import org.hackamarte.solidarize.exception.NotFoundException;
import org.hackamarte.solidarize.model.Solicitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class SolicitationService {

    @Autowired
    private org.hackamarte.solidarize.repository.SolicitationRepository SolicitationRepository;

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
