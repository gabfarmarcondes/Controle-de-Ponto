package controle_ponto.project.model;

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
    @Column(name = "employee_id")
    private Long employeeId;
    private Date date;
    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;
    private LocalTime startDateTime;
    private LocalTime endDateTime;
    @Column(length = 100)
    private String notes;
}
