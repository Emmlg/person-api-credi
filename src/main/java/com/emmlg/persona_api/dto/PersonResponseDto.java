package com.emmlg.persona_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

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

    private LocalDateTime creatAt;

    private boolean active;
}
