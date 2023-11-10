package academic.hub.service.impl;

import academic.hub.exception.EntityNotFoundException;
import academic.hub.model.Department;
import academic.hub.model.Lector;
import academic.hub.repository.DepartmentRepository;
import academic.hub.service.DepartmentService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public String getDepartmentHeadName(String departmentName) {
        Lector head = getDepartmentByName(departmentName).getHead();
        return head.getFirstName() + " " + head.getLastName();
    }

    @Override
    public String getStatistic(String departmentName) {
        return departmentRepository.getStatistic(departmentName);
    }

    @Override
    public BigDecimal getAverageSalary(String departmentName) {
        return departmentRepository.getAverageLectorsSalary(departmentName);
    }

    @Override
    public int getNumberOfEmployees(String departmentName) {
        return departmentRepository.getCountLectors(departmentName);
    }

    private Department getDepartmentByName(String name) {
        return departmentRepository
                .findByName(name).orElseThrow(() -> new EntityNotFoundException(
                        "Can't find department by name: " + name));
    }
}
