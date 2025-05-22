package aws9.acon.noticeservice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Sample {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
