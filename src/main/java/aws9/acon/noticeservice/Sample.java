package aws9.acon.noticeservice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Sample {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
