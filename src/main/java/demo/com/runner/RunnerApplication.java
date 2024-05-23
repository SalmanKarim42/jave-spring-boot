package demo.com.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication {

    private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);

        // log.info("Welcome to the world of Spring Boot! 11");
        // var welcome = new WelcomeMessage();
        // System.out.println(welcome.getWelcomeMessage());
    }

    // @Bean
    // CommandLineRunner runner(RunRepository runRepository) {
    // return args -> {

    // Run run = new Run(2, "Morning Run", LocalDateTime.now(),
    // LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);

    // runRepository.create(run);
    // // log.info("Run: {}", run);
    // };
    // }

}
