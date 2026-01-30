package com.emmlg.persona_api.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

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
