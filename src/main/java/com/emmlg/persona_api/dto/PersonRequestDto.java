package com.emmlg.persona_api.dto;

import com.emmlg.persona_api.commons.validation.ValidAge;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import static com.emmlg.persona_api.commons.contants.Constant.INVALID_VALUE;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

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
