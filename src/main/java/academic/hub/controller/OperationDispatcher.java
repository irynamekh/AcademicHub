package academic.hub.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@RequiredArgsConstructor
public class OperationDispatcher implements BeanPostProcessor {

    private final List<OperationMethod> operationMethods = new ArrayList<>();

    public void dispatch(String input) {
        for (OperationMethod operationMethod : operationMethods) {
            var inputMatcher = operationMethod.pattern.matcher(input);
            if (inputMatcher.matches()) {
                operationMethod.operate(inputMatcher.group(1));
                return;
            }
        }
        throw new NoSuchElementException("Invalid input");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getAnnotation(OperationController.class) != null) {
            var operationMethodsOfBean = Arrays.stream(bean.getClass().getDeclaredMethods())
                    .flatMap(method -> Optional.ofNullable(method.getAnnotation(Operation.class)).stream()
                            .map(operation -> new OperationMethod(
                                    bean,
                                    method,
                                    Pattern.compile(operation.value())
                            )))
                    .toList();

            operationMethods.addAll(operationMethodsOfBean);
        }
        return bean;
    }

    private record OperationMethod(
            Object controller,
            Method method,
            Pattern pattern
    ) {

        @SneakyThrows
        public void operate(String argument) {
            method.invoke(controller, argument);
        }
    }
}
