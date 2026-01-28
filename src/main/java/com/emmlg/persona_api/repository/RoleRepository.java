package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
