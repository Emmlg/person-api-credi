package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */
@Repository
public interface AuthRepository extends JpaRepository<AuthEntity,Integer> {

    Optional<AuthEntity> findByUsernameIgnoreCase(String username);
}
