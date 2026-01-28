package com.emmlg.persona_api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonResponseDto implements Serializable {

    private Integer personId;

    private String name;

    private String lastName;

    private String email;

    private LocalDate birthdate;

    private Integer age;

    private LocalDate creatAt;

    private boolean active;
}
