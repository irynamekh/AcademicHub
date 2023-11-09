package academic.hub.service.strategy.operation;

import academic.hub.service.DepartmentService;
import academic.hub.service.strategy.OperationHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AverageSalaryHandler implements OperationHandler {
    private static final Pattern INPUT_REGEX = Pattern.compile(
            "Show the average salary for the department (.+)");
    private final DepartmentService departmentService;

    @Override
    public boolean canOperate(String input) {
        Matcher matcher = INPUT_REGEX.matcher(input);
        return matcher.matches();
    }

    @Override
    public void operate(String input) {
        Matcher matcher = INPUT_REGEX.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalStateException("Invalid input");
        }
        String departmentName = matcher.group(1);

        System.out.println("The average salary of " + departmentName + " is "
                 + departmentService.getAverageSalary(departmentName));
    }
}
