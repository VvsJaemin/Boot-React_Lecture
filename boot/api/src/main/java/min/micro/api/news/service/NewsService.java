package min.micro.api.news.service;

import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.News;
import org.jsoup.nodes.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    public List<News> newsFindAll();
//    public List<HomeNews> homeNewsFindAll();
    public void crawlingHome() ;
    List<News> saveAll(Crawler crawler) throws IOException;
    Page<News> findAll(final Pageable pageable);
    public Optional<News> findByNewsId(String newsId);
    public void OptionalInit(String newsId);
//    public ClickedNews crawlingOne(String newsNo);
}