
package org.example.AiDemoService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChatRequestDTO {

    @NotBlank
    private String message;
}

