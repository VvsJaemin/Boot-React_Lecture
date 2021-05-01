package min.micro.api.news.repository;

import min.micro.api.news.domain.Bugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface BugsRepository extends JpaRepository<Bugs, Long> {
}
