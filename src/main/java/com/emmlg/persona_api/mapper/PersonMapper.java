package com.emmlg.persona_api.mapper;

import com.emmlg.persona_api.dto.PersonRequestDto;
import com.emmlg.persona_api.dto.PersonResponseDto;
import com.emmlg.persona_api.dto.pagination.PaginationResponse;
import com.emmlg.persona_api.model.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import static com.emmlg.persona_api.util.DateUtil.getAgeFromBirthDate;
import static com.emmlg.persona_api.util.PaginationUtils.mapToPageInfo;

@Component
public class PersonMapper {

    public PersonEntity DtoToPerson (PersonRequestDto personDto){

        PersonEntity saved = new PersonEntity();
        saved.setName(personDto.getName());
        saved.setLastName(personDto.getLastName());
        saved.setBirthdate(personDto.getBirthdate());
        saved.setEmail(personDto.getEmail());
        saved.setActive(personDto.getActive());

        return saved;
    }

    public PersonEntity updatePersonFromDto (PersonRequestDto personDto, PersonEntity personEntity){

        personEntity.setName(personDto.getName());
        personEntity.setLastName(personDto.getLastName());
        personEntity.setBirthdate(personDto.getBirthdate());
       // personEntity.setEmail(personDto.getEmail());
        personEntity.setActive(personDto.getActive());

        return personEntity;
    }


    public PersonResponseDto PersonToRespDto(PersonEntity person){

        return PersonResponseDto
                .builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .birthdate(person.getBirthdate())
                .age(getAgeFromBirthDate(person.getBirthdate()))
                .creatAt(person.getCreationDate())
                .active(person.isActive())
                .build();
    }

    public PaginationResponse<PersonResponseDto> PToPaginationRespDto (Page<PersonEntity> personsPage){

            var pageInfo = mapToPageInfo(personsPage);

            var personDtoList = personsPage.stream()
                    .map(this::PersonToRespDto)
                    .toList();

        return PaginationResponse.<PersonResponseDto>builder()
                .data(personDtoList)
                .pagination(pageInfo)
                .build();
    }

}
