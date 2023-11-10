package academic.hub.service;

import academic.hub.dto.DepartmentStatistics;
import java.math.BigDecimal;

public interface DepartmentService {
    String getDepartmentHeadName(String departmentName);

    String getStatistic(String departmentName);

    BigDecimal getAverageSalary(String departmentName);

    int getNumberOfEmployees(String departmentName);
}
