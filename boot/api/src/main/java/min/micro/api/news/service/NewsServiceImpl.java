package min.micro.api.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.cmm.service.CrawlerServiceImpl;
import min.micro.api.news.domain.News;
import min.micro.api.news.repository.NewsRepository;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Lazy
@RequiredArgsConstructor // 상태를 변경할 수 없도록 생성자 주입(무상태)
@Log
public class NewsServiceImpl extends AbstractService<News> implements NewsService {


    private final NewsRepository repository; // final - >  상수처리 - > 무상태


    @Override
    public List<News> newsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }

    @Override
    public List<News> saveAll(Crawler crawler) throws IOException {
        Document document = CrawlerServiceImpl.connectUrl(crawler.getUrl()); // jsoup 불변객체, https
        repository.deleteAll();
        Elements elements = document.select(crawler.getCssQuery());
        //"div.sect-movie-chart>ol>li>div.box-image>strong"
        List<News> newslist = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            News news = new News();

            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
            newslist.add(news);
            repository.save(news);

        }
        return newslist;
    }

    @Override
    public Optional<News> findByNewsId(String newsId) {
        return Optional.empty();
    }


    @Override
    public void OptionalInit(String newsId) {
        Optional<String> optVal = Optional.empty(); // Optional Initializer
    }

    @Override
    public Long save(News news) {
        // 스크래핑이 발생함함
        return (repository.save(news) != null) ? 1L : 0L;
    }

    public Long saveAll() {
        return 0L;
    }

    @Override
    public Optional<News> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Optional<News> getOne(long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Long delete(News news) {
        repository.delete(news);

        return (findById(news.getNewsId())).orElse(null) == null ? 1L : 0L;
//                n.orElseThrow().getNewsId();
    }

    @Override
    public Boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
