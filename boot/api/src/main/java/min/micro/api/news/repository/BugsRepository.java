package min.micro.api.news.repository;

import min.micro.api.news.domain.Bugs;
import min.micro.api.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugsRepository extends JpaRepository<Bugs, Long> {

    Bugs findByBugsNo(String titleNo);
}
