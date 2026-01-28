package com.emmlg.persona_api.commons.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAge, LocalDate> {

    private int minAge;

    @Override
    public void initialize(ValidAge annotation) {
        this.minAge = annotation.minAge();
    }

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext constraintValidatorContext) {

        if (birthdate == null) return true; // @NotNull lo maneja
        return Period.between(birthdate, LocalDate.now()).getYears() >= minAge;

    }
}
