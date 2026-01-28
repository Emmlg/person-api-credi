package com.emmlg.persona_api.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class PersonExceptionController {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<CommonErrorResponse> handlePersonExceptions(PersonException ex) {
        if (ex.getHttpStatus() == HttpStatus.INTERNAL_SERVER_ERROR) log.error("Cause: {}", ex.getMessage());

        return ResponseEntity.status(ex.getHttpStatus())
                .body(CommonErrorResponse.builder()
                        .message(ex.getMessage())
                        .process(ex.getProcess())
                        .httpStatus(ex.getHttpStatus())
                        .build());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class,
            MethodArgumentConversionNotSupportedException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonErrorResponse handleAllArgumentExceptions(Exception exception) {
        log.error(exception.getMessage());
        return CommonErrorResponse.builder()
                .message("Invalid request parameters")
                .process("REQUEST_VALIDATION")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonErrorResponse handleAllExceptions(Exception ex) {

        log.error("Unhandled exception", ex);

        return CommonErrorResponse.builder()
                .message("Sorry, the server could not process your request. Please try again later." )
                .process("UNEXPECTED_ERROR")
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }


}
