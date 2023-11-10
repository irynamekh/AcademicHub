package academic.hub.controller.operation;

import academic.hub.controller.Operation;
import academic.hub.controller.OperationController;
import academic.hub.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@OperationController
@RequiredArgsConstructor
public class SearchLectorByTemplateController {

    private final LectorService lectorService;

    @Operation("Global search by (.+)")
    public void operate(String departmentName) {
        String searchResults = String.join(", ", lectorService.getLectorByTemplate(departmentName));
        System.out.println(searchResults);
    }
}
