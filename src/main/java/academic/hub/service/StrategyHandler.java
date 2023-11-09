package academic.hub.service;

import academic.hub.service.strategy.OperationHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StrategyHandler {
    private final List<OperationHandler> operationHandlers;

    public void process(String input) {
        var handler = operationHandlers.stream()
                .filter(it -> it.canOperate(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid input"));
        handler.operate(input);
    }
}
