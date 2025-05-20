package aws9.acon.noticeservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "services-url")
public class ServicesUrl {
    private String central;
}
