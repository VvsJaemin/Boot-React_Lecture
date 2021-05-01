package min.micro.api.news.repository;

import min.micro.api.news.domain.Cgv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgvRepository extends JpaRepository<Cgv, Long> {
}
