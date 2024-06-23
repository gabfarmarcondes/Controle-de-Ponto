package controle_ponto.project.controller;

import controle_ponto.project.dto.RequestEmployee;
import controle_ponto.project.model.Employee;
import controle_ponto.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emps")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findEmployeeById(id);
        if (employee.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Validated RequestEmployee employee) {
        Employee newEmployee = new Employee(employee);
        employeeRepository.save(newEmployee);
        return ResponseEntity.ok(newEmployee);
    }

    @GetMapping("/test")
    public String hello(){
        return "Hello World";
    }
}
