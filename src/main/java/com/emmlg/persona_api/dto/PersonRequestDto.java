package com.emmlg.persona_api.dto;

import com.emmlg.persona_api.commons.validation.ValidAge;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.emmlg.persona_api.commons.contants.Constant.INVALID_VALUE;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonRequestDto {

    @NotBlank(message = INVALID_VALUE)
    private String name;

    @NotBlank(message = INVALID_VALUE)
    private String lastName;

    @NotBlank(message = INVALID_VALUE)
    private String email;

    @ValidAge
    @NotNull(message = INVALID_VALUE)
    private LocalDate birthdate;

    @NotNull(message = INVALID_VALUE)
    private Boolean active;
}
