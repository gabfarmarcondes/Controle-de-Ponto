package controle_ponto.project.services.ponto;

import controle_ponto.project.model.WorkShift;
import controle_ponto.project.repository.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkShiftServices {

    @Autowired
    private WorkShiftRepository wsRepository;

    public List<WorkShift> getWorkShiftsByEmployeeId(Long employeeId) {
        return wsRepository.findByEmployeeId(employeeId);
    }

}
