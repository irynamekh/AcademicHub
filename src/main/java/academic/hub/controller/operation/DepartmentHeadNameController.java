package academic.hub.controller.operation;

import academic.hub.controller.Operation;
import academic.hub.controller.OperationController;
import academic.hub.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@OperationController
@RequiredArgsConstructor
public class DepartmentHeadNameController {
    private final DepartmentService departmentService;

    @Operation("Who is head of department (.+)")
    public void operate(String departmentName) {
        System.out.println("Head of " + departmentName + " department is "
                + departmentService.getDepartmentHeadName(departmentName));
    }
}
