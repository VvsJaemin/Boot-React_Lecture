package min.micro.api.news.service;

import min.micro.api.news.domain.News;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    public Document connectUrl(String url) throws IOException;
    public List<News> newsFindAll();
//    public List<HomeNews> homeNewsFindAll();
    public void crawlingHome() ;
    Long saveAll(String category) throws IOException;
    public Optional<News> findByNewsNo(String newsNo);
    public void OptionalInit(String newsNo);
//    public ClickedNews crawlingOne(String newsNo);
}