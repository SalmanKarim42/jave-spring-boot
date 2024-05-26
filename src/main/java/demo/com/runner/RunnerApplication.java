package demo.com.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import demo.com.runner.user.User;
import demo.com.runner.user.UserHttpClient;

@SpringBootApplication
public class RunnerApplication {

    private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);

        // log.info("Welcome to the world of Spring Boot! 11");
        // var welcome = new WelcomeMessage();
        // System.out.println(welcome.getWelcomeMessage());
    }

    @Bean
    UserHttpClient userHttpClient() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(UserHttpClient.class);
    }

    @Bean
    CommandLineRunner runner(UserHttpClient client) {
        return args -> {
            // Run run = new Run(1, "Morning Run", LocalDateTime.now(),
            // LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);

            // log.info("Run: {}", run);
            List<User> users = client.findAll();
            System.out.println(users);

            User user = client.findById(1);
            System.out.println(user);
        };
    }

}
