package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
