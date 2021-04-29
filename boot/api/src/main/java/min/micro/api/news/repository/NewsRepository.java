package min.micro.api.news.repository;

import min.micro.api.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

     News findByNewsNo(String newsNo);

}
