package aws9.acon.noticeservice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sample {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
