package controle_ponto.project.controller;

import controle_ponto.project.dto.RequestEmployee;
import controle_ponto.project.model.Employee;
import controle_ponto.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody @Validated RequestEmployee employee) {
        Employee updatedEmployee = employeeRepository.findEmployeeById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        updatedEmployee.setJob(employee.job());
        updatedEmployee.setName(employee.name());
        employeeRepository.save(updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = employeeRepository.findEmployeeById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employeeRepository.delete(deletedEmployee);
        return ResponseEntity.ok(deletedEmployee);
    }
}