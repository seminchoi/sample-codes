package aws9.acon.noticeservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
public class Sample {
    @Id
    private Integer id;
    private String title;
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;
}
