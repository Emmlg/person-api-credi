package com.emmlg.persona_api.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonErrorResponse {

    @Schema(description = "HTTP Status")
    private HttpStatus httpStatus;

    @Schema(description = "Mensaje de error")
    private String message;

    @Schema(description = "Proceso")
    private String process;

    @Schema(description = "Detalles del error")
    private List<String> errors;


}
