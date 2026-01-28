package com.emmlg.persona_api.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PersonException extends RuntimeException {

    private String process;
    private HttpStatus httpStatus;

}
