package academic.hub.controller.operation;

import academic.hub.controller.Operation;
import academic.hub.controller.OperationController;
import academic.hub.dto.DepartmentStatistics;
import academic.hub.service.DepartmentService;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@OperationController
@RequiredArgsConstructor
public class StatisticController {

    private final DepartmentService departmentService;

    @Operation("Show (.+) statistics")
    public void operate(String departmentName) {
        int[] statistic = Arrays.stream(departmentService.getStatistic(departmentName).split(","))
                .mapToInt(Integer::parseInt).toArray();
        String[] degrees = {"assistans", "associate professors", "professors"};
        String output = IntStream.range(0, degrees.length)
                .mapToObj(i -> degrees[i] + " - " + statistic[i])
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
