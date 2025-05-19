package aws9.acon.noticeservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Sample, Integer> {
    Page<Sample> findAll(Pageable pageable);
}
