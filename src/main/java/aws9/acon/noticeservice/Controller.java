package aws9.acon.noticeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
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
    public ResponseEntity<Sample> getSample() {
        random();
        return ResponseEntity.ok(generateSample());
    }


    public static Sample generateSample() {
        return Sample.builder()
                .id(new Random().nextInt(10000))
                .title("샘플 제목입니다.")
                .content(generateNumericString(10_000))
                .createdAt(LocalDateTime.now())
                .build();
    }

    private static String generateNumericString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // 0 ~ 9
        }

        return sb.toString();
    }


    private void random() {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            int randInt = random.nextInt();
            randoms.add(randInt);
        }
        randoms.sort(Integer::compareTo);
    }
}
