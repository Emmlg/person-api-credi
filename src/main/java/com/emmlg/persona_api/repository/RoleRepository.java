package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
