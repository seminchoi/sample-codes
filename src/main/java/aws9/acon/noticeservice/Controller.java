package aws9.acon.noticeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Repository repository;
    private AtomicInteger counter = new AtomicInteger(0);

    // Health check
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("healthy");
    }

    @GetMapping("/core/{id}")
    public ResponseEntity<Sample> getSample(int id) {
        return ResponseEntity.ok(
                repository.findById(counter.get() % 1_000_000).orElse(new Sample())
        );
    }
}
