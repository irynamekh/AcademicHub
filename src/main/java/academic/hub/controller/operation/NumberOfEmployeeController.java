package academic.hub.controller.operation;

import academic.hub.controller.Operation;
import academic.hub.controller.OperationController;
import academic.hub.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@OperationController
@RequiredArgsConstructor
public class NumberOfEmployeeController {
    private final DepartmentService departmentService;

    @Operation("Show count of employee for (.+)")
    public void operate(String departmentName) {
        System.out.println(departmentService.getNumberOfEmployees(departmentName));
    }
}
