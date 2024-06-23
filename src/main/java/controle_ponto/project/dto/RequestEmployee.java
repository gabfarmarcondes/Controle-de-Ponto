package controle_ponto.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record RequestEmployee(
        @NotNull Long id,
        @NotNull @NotBlank(message = "Please provide a Name") String name,
        @NotNull @NotBlank(message = "Please provide a job")String job) {
}
