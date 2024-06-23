package controle_ponto.project.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record RequestEmployee(
        Long id,
        @NotBlank(message = "Please provide a Name") String name,
        @NotBlank(message = "Please provide a job")String job) {
}
