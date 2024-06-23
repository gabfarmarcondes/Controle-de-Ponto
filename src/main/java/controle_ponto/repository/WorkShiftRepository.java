package controle_ponto.repository;

import controle_ponto.model.Employee;
import controle_ponto.model.WorkShift;

import java.sql.Date;
import java.util.Optional;

public interface WorkShiftRepository {
    WorkShift findByDate(Date date);
    Optional<WorkShift>findByEmployeeAndDate(Employee employee, Date date);
    Optional<WorkShift>findByEmployee(Employee employee);
    Optional<WorkShift>findByShift(String shift);

}
