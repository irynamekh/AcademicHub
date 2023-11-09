package academic.hub.service.strategy;

public interface OperationHandler {

    boolean canOperate(String input);

    void operate(String input);
}
