package com.emmlg.persona_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse {

    @Schema(description = "error message")
    private String message;

    @Schema(description = "process")
    private String process;

    @Schema(description = "HTTP Status")
    private HttpStatus httpStatus;
}
