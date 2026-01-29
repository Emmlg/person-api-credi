package com.emmlg.persona_api.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class PersonExceptionController {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<CommonErrorResponse> handlePersonExceptions(PersonException ex) {
        if (ex.getHttpStatus() == HttpStatus.INTERNAL_SERVER_ERROR) log.error("Cause: {}", ex.getMessage());

        return ResponseEntity.status(ex.getHttpStatus())
                .body(CommonErrorResponse.builder()
                        .httpStatus(ex.getHttpStatus())
                        .message(ex.getMessage())
                        .process(ex.getProcess())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        return CommonErrorResponse.builder()
                .message("Validation failed")
                .process("REQUEST_VALIDATION")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .errors(errors)
                .build();
    }

    @ExceptionHandler({
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
