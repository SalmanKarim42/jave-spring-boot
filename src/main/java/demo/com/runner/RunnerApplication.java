package demo.com.runner;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.com.runner.run.Location;
import demo.com.runner.run.Run;
import demo.com.runner.run.RunRepository;

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
    //     return args -> {

    //         Run run = new Run(2, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
			
    //         runRepository.create(run);
	// 		// log.info("Run: {}", run);
    //     };
    // }

}
