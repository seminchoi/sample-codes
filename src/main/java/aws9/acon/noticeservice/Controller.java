package aws9.acon.noticeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Repository repository;
    private final ServicesUrl servicesUrl;

    private RestTemplate restTemplate = new RestTemplate();
    private Random random = new Random();

    // Health check
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("healthy");
    }
    
    @GetMapping("/notices")
    public ResponseEntity<List<Sample>> getList() {
        int page = random.nextInt(10_000);
        int id = random.nextInt(1_000_000);

        if(id % 3 == 0) {
            Sample sample = restTemplate.getForObject(servicesUrl.getCentral() + "/" + id, Sample.class);
            String content = sample.getContent();
        }

        Pageable pageable = PageRequest.of(page, 100);
        return ResponseEntity.ok(repository.findAll(pageable).map(n -> n).toList());
    }
}
