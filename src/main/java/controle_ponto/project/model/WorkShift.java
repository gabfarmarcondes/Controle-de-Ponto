package controle_ponto.project.model;

import controle_ponto.project.dto.RequestWorkShift;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "workShift")
@Table(name = "workShift_tab")
public class WorkShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

    private Date date;

    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;

    private LocalTime startDateTime;
    private LocalTime endDateTime;

    @Column(length = 100)
    private String notes;

    public WorkShift(RequestWorkShift workShift, Employee employee) {
        this.id = workShift.id();
        this.employee = employee;
        this.date = (Date) workShift.date();
        this.shiftType = workShift.shiftType();
        this.startDateTime = workShift.start();
        this.endDateTime = workShift.end();
        this.notes = workShift.notes();
    }
}
