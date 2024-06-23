package controle_ponto.repository;

import controle_ponto.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeById(long id);
    Optional<Employee> findEmployeeByNameAndAndJob(String name, String job);

}
