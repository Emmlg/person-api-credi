package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
