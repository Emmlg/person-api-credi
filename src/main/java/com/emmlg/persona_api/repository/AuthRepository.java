package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthRepository extends JpaRepository<AuthEntity,Integer> {

    Optional<AuthEntity> findByUsernameIgnoreCase(String username);
}
