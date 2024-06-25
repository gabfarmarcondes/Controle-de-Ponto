package controle_ponto.project.controller;


import controle_ponto.project.dto.RequestWorkShift;
import controle_ponto.project.model.Employee;
import controle_ponto.project.model.WorkShift;
import controle_ponto.project.repository.EmployeeRepository;
import controle_ponto.project.repository.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/work")
public class WorkShiftController {

    @Autowired
    private WorkShiftRepository workShiftRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/find")
    public ResponseEntity getWorkShifts() {
        return ResponseEntity.ok(workShiftRepository.findAll());
    }

    @PostMapping("/createWork")
    public ResponseEntity<WorkShift> createWorkShift(@RequestBody @Validated RequestWorkShift workShift) {
        Employee employee = employeeRepository.findById(workShift.employeeID().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        WorkShift newWorkShift = new WorkShift(workShift, employee);
        workShiftRepository.save(newWorkShift);
        return ResponseEntity.ok(newWorkShift);
    }
}
