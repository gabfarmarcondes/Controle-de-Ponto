package controle_ponto.project.model;

import controle_ponto.project.dto.RequestEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "employee")
@Table(name = "employee_tab")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private WorkShift workShift;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String job;

    public Employee(RequestEmployee requestEmployee) {
        this.id = requestEmployee.id();
        this.name = requestEmployee.name();
        this.job = requestEmployee.job();
    }
}
