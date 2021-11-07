package org.hackamarte.impact.repository;

import org.hackamarte.impact.model.IntentionOfGiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IntentionOfGiverRepository extends JpaRepository<IntentionOfGiver, UUID> {
}