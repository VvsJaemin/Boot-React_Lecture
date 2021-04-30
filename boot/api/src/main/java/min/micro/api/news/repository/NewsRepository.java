package min.micro.api.news.repository;

import min.micro.api.news.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//@NoRepositoryBean
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {




}
