package com.emmlg.persona_api.service;

import com.emmlg.persona_api.dto.GeneralResponse;
import com.emmlg.persona_api.dto.PersonRequestDto;
import com.emmlg.persona_api.dto.PersonResponseDto;
import com.emmlg.persona_api.dto.pagination.PaginationResponse;
import com.emmlg.persona_api.exceptions.PersonException;
import com.emmlg.persona_api.mapper.PersonMapper;
import com.emmlg.persona_api.model.PersonEntity;
import com.emmlg.persona_api.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Fallback;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Transactional
    public PersonResponseDto createPerson(PersonRequestDto newPerson){

        if (personRepository.existsByEmail(newPerson.getEmail())){
            throw new PersonException(
                "Person already exists",
                "Creating person",
                HttpStatus.CONFLICT
            );
        }

        var personEntity = personMapper.DtoToPerson(newPerson);
        personEntity.setCreationDate(LocalDateTime.now());

        PersonEntity savedPerson = personRepository.save(personEntity);
        return personMapper.PersonToRespDto (savedPerson);

    }

    @Transactional
    public PersonResponseDto updatePerson(Integer personId, PersonRequestDto updatedPersonDto){
        PersonEntity existingPerson = personRepository.findById(personId).orElseThrow(
                ()-> new PersonException(
                        "Person not found",
                        "Updating person",
                        HttpStatus.NOT_FOUND
                )
        );

        var savedPerson = personMapper.updatePersonFromDto(updatedPersonDto, existingPerson);
        return personMapper.PersonToRespDto(savedPerson);
    }

    @Transactional
    public GeneralResponse deletePerson(Integer personId){
        PersonEntity existingPerson = personRepository.findById(personId).orElseThrow(
                ()-> new PersonException(
                        "Person not found",
                        "Deleting person",
                        HttpStatus.NOT_FOUND
                )
        );

        personRepository.delete(existingPerson);
        return GeneralResponse.builder()
                .message("Person deleted successfully")
                .process("Deleting person")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Transactional
    public GeneralResponse disablePerson(Integer personId){
        PersonEntity existingPerson = personRepository.findById(personId).orElseThrow(
                ()-> new PersonException(
                        "Person not found",
                        "Disabling person",
                        HttpStatus.NOT_FOUND
                )
        );

        existingPerson.setActive(false);
        personRepository.save(existingPerson);
        return GeneralResponse.builder()
                .message("Person disabled successfully")
                .process("Disabling person")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public PersonResponseDto getPersonById(Integer personId){
        PersonEntity existingPerson = personRepository.findById(personId).orElseThrow(
                ()-> new PersonException(
                        "Person not found",
                        "Fetching person",
                        HttpStatus.NOT_FOUND
                )
        );

        return personMapper.PersonToRespDto(existingPerson);
    }

    public PaginationResponse<PersonResponseDto> getPersons(Pageable pg) throws PersonException{

        var personsPage = personRepository.findAll(pg);
        return personMapper.PToPaginationRespDto(personsPage);
    }

}
