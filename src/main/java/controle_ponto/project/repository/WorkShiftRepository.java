package controle_ponto.project.repository;

import controle_ponto.project.model.Employee;
import controle_ponto.project.model.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface WorkShiftRepository extends JpaRepository<WorkShift, Long> {
    WorkShift findByDate(Date date);

    @Query("SELECT ws FROM workShift ws WHERE ws.employee.id = :employeeId")
    List<WorkShift> findByEmployeeId(@Param("employeeId") Long employeeId);

}
