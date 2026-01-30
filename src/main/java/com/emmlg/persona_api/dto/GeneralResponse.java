package com.emmlg.persona_api.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

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
public class GeneralResponse {

    private String message;

    private String process;

    private HttpStatus httpStatus;
}
