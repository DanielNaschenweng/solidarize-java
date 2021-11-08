package org.hackamarte.solidarize.repository;

import org.hackamarte.solidarize.model.IntentionOfGiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IntentionOfGiverRepository extends JpaRepository<IntentionOfGiver, UUID> {
}