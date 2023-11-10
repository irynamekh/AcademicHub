package academic.hub;

import academic.hub.controller.OperationDispatcher;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import liquibase.Scope;
import liquibase.ScopeManager;
import liquibase.SingletonScopeManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class HubApplication {
    private final OperationDispatcher operationDispatcher;

    public static void main(String[] args) {
        SpringApplication.run(HubApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            while (true) {
                System.out.print("User Input: ");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                String input = reader.readLine();
                if (input.equals("Exit")) {
                    break;
                }
                operationDispatcher.dispatch(input);
            }
        };
    }
}
