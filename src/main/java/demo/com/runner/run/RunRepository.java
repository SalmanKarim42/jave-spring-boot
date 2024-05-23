package demo.com.runner.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();

    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isEmpty())
            throw new RunNotFoundException();

        runs.set(runs.indexOf(existingRun.get()), run);
    }

    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isEmpty())
            throw new RunNotFoundException();

        runs.remove(existingRun.get());
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(5), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plusDays(2), 3, Location.INDOOR));
    }
}
