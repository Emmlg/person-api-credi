package com.emmlg.persona_api.controller;

import com.emmlg.persona_api.dto.GeneralResponse;
import com.emmlg.persona_api.dto.PersonRequestDto;
import com.emmlg.persona_api.dto.PersonResponseDto;
import com.emmlg.persona_api.dto.pagination.PaginationResponse;
import com.emmlg.persona_api.exceptions.PersonException;
import com.emmlg.persona_api.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Person")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/select/person")
public class PersonController {

    private final PersonService personService;

    @Operation(summary = " General registration for a person")
    @ApiResponse(responseCode = "201", description = "Person registered successfully")
    @PostMapping
    public PersonResponseDto createPerson(@Valid @RequestBody PersonRequestDto personReqDto) throws PersonException {
        return personService.createPerson(personReqDto);
    }

    @Operation(summary = "Get all persons with pagination")
    @ApiResponse(responseCode = "200", description =" Persons retrieved successfully")
    @GetMapping
    public PaginationResponse<PersonResponseDto> getPersons(
            @PageableDefault(size = 10,
                    sort = "creationDate",
                    direction = Sort.Direction.ASC) Pageable pageable) throws PersonException {

        return personService.getPersons(pageable);
    }

    @Operation(summary = "Get person by ID")
    @ApiResponse(responseCode = "200", description =" Persons retrieved successfully")
    @GetMapping("/{id}")
    public PersonResponseDto getPersonById(@PathVariable("id") Integer personId) throws PersonException {
        return personService.getPersonById(personId);
    }

    @Operation(summary = "Update person by ID")
    @ApiResponse(responseCode = "200", description =" Persons updated successfully")
    @PutMapping("/{id}")
    public PersonResponseDto updatePerson(@PathVariable("id") Integer personId,
                                          @Valid @RequestBody PersonRequestDto personReqDto) throws PersonException {
        return personService.updatePerson(personId,personReqDto);
    }

    @Operation(summary = "Disable person by ID")
    @ApiResponse(responseCode = "200", description ="Persons disabled successfully")
    @PutMapping("/disable/{id}")
    public GeneralResponse disablePerson(@PathVariable("id") Integer personId) throws PersonException{
        return personService.disablePerson(personId);
    }

    @Operation(summary = "Delete person by ID")
    @ApiResponse(responseCode = "200", description ="Persons deleted successfully")
    @DeleteMapping("/{id}")
    public GeneralResponse deletePerson(@PathVariable("id") Integer personId) throws PersonException {
        return personService.deletePerson(personId);
    }
}
