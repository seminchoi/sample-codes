package aws9.acon.noticeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ServicesUrl servicesUrl;

    private RestTemplate restTemplate = new RestTemplate();
    private Random random = new Random();

    // Health check
    @GetMapping("/healthz")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("healthy");
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Sample>> getList() {
        List<Sample> samples = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Sample sample = restTemplate.getForObject(servicesUrl.getCentral(), Sample.class);
//            samples.add(sample);
//        }
        random();

        return ResponseEntity.ok(samples);
    }

    private void random() {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            int randInt = random.nextInt();
            randoms.add(randInt);
        }
        randoms.sort(Integer::compareTo);
    }
}
