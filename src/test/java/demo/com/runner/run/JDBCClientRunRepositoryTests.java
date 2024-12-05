package demo.com.runner.run;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(JDBCClientRunRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JDBCClientRunRepositoryTests {

    @Autowired
    JDBCClientRunRepository repository;

    @BeforeEach
    void setup() {
        repository.create(
                new Run(3, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        repository.create(new Run(4, "Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5,
                Location.OUTDOOR));
    }

    @Test
    void testFindAll() {
        var runs = repository.findAll();
        assertEquals(2, runs.size());
    }

}
