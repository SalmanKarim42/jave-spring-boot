package demo.com.runner.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestClientTest(UserRestClient.class)
class UserRestClientTests {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    UserRestClient client;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldFindAllUsers() throws JsonProcessingException {
        // given
        User user = new User(1, "John", "Doe", "jhon@gmail.com",
                new Address("123 Main St", "Springfield", "USA", "dskjfs", new Geo("12323", "4234234")),
                "123-456-7890", "org.com", new Company("sdfkldsf", "dslkjf", "lksdjfds"));

        List<User> users = List.of(user);

        // when 
        server.expect(requestTo("https://jsonplaceholder.typicode.com/users"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(users), MediaType.APPLICATION_JSON));

        
        // then
        List<User> allUsers = client.findAll();
        assertEquals(users, allUsers);

    }

}
