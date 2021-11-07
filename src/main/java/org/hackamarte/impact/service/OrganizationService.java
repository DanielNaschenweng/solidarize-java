package org.hackamarte.impact.service;

import lombok.NoArgsConstructor;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class OrganizationService {
    
    @Autowired
    private org.hackamarte.impact.repository.OrganizationRepository OrganizationRepository;

    public Organization find(UUID id) {
        return OrganizationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Organização não encontrada com ID: "+id));
    }

    public Organization create(Organization Organization) {
        return OrganizationRepository.save(Organization);
    }

    public Organization update(Organization Organization) {
        return OrganizationRepository.save(Organization);
    }
}
