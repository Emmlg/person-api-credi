package com.emmlg.persona_api.commons.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidAge {

    int minAge() default 18;

    String message() default "Must be at least {minAge} years old";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
