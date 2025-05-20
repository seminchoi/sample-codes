package aws9.acon.noticeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @GetMapping("/notices")
    public List<Sample> getList() {
        int page = counter.getAndIncrement();
        page %= 1_999;
        Pageable pageable = PageRequest.of(page, 500);
        return repository.findAll(pageable).map(n -> n).toList();
    }
}
