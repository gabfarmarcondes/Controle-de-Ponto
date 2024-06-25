package controle_ponto.project.dto;

import controle_ponto.project.model.Employee;
import controle_ponto.project.model.ShiftType;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;
import java.util.Date;

@Validated
public record RequestWorkShift(
        Long id,
        Employee employeeID,
        Date date,
        ShiftType shiftType,
        LocalTime start,
        LocalTime end,
        String notes
)
{
}
