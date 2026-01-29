package com.emmlg.persona_api.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class PersonException extends RuntimeException {

    private HttpStatus httpStatus;
    private String process;


    public PersonException(String message, String process, HttpStatus httpStatus) {
        super(message);
        this.process = process;
        this.httpStatus = httpStatus;
    }

}
