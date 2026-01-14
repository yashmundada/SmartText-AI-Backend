

package org.example.AiDemoService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SummarizeRequestDTO {

    @NotBlank
    @Size(min = 20)
    private String text;

}
