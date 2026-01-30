package com.emmlg.persona_api.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonErrorResponse {

    private HttpStatus httpStatus;

    private String message;

    private String process;

    private List<String> errors;


}
