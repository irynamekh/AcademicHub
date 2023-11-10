package academic.hub.controller.operation;

import academic.hub.controller.Operation;
import academic.hub.controller.OperationController;
import academic.hub.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@OperationController
@RequiredArgsConstructor
public class AverageSalaryController {

    private final DepartmentService departmentService;

    @Operation("Show the average salary for the department (.+)")
    public void operate(String departmentName) {
        System.out.println("The average salary of " + departmentName + " is "
                 + departmentService.getAverageSalary(departmentName));
    }
}
