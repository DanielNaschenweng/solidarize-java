package org.hackamarte.impact.repository;

import org.hackamarte.impact.model.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SolicitationRepository extends JpaRepository<Solicitation, UUID> {
}