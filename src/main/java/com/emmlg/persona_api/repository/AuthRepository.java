package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity,Integer> {

}
