package com.emmlg.persona_api.repository;

import com.emmlg.persona_api.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

}
