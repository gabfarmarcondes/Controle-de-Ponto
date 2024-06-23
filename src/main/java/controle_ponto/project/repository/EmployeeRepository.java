package controle_ponto.project.repository;

import controle_ponto.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(long id);
    Optional<Employee> findEmployeeByNameAndJob(String name, String job);

}
