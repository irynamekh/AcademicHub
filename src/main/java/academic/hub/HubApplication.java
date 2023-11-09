package academic.hub;

import academic.hub.service.StrategyHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class HubApplication {
    private final StrategyHandler strategyHandler;

    public static void main(String[] args) {
        SpringApplication.run(HubApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            while (true) {
                System.out.println("User Input: ");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                String input = reader.readLine();
                if (input.equals("Exit")) {
                    break;
                }
                strategyHandler.process(input);
            }
        };
    }
}
