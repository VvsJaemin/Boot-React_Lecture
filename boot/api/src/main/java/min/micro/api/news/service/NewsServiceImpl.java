package min.micro.api.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.news.domain.News;
import min.micro.api.news.repository.NewsRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Lazy
@RequiredArgsConstructor // 상태를 변경할 수 없도록 생성자 주입(무상태)
@Log
public class NewsServiceImpl extends AbstractService<News> implements NewsService {


    private final NewsRepository repository; // final - >  상수처리 - > 무상태

    @Override
    public Document connectUrl(String url) throws IOException {
        log.info("connectUrl() : " + url);

        return Jsoup.connect(url) // 클래스 안에 이너클래스
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute().parse();


    }

    @Override
    public List<News> newsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }

    @Override
    public Long saveAll(String category) throws IOException {
        Document cgvdocument = connectUrl("http://www.cgv.co.kr/" + category); // jsoup 불변객체
        repository.deleteAll();

        Elements cgvelements = cgvdocument.select("div.sect-movie-chart>ol>li>div.box-image>strong");
        int count = 0;
        for (int i = 0; i < cgvelements.size(); i++) {
            News news = new News();

            news.setTitle(cgvelements.get(i).text());
            news.setAddress(cgvelements.get(i).attr("href"));
            news.setCategory(category);
//           repository.save(news);

            count++;

            System.out.println("************** News 정보" + news.toString());
        }
        System.out.println("************** 크롤링 카운트" + count);
        return 0L;
    }


    @Override
    public Optional<News> findByNewsNo(String newsNo) {
        Optional.ofNullable(repository.findByNewsNo(newsNo)).ifPresent(System.out::println);
        return Optional.ofNullable(repository.findByNewsNo(newsNo)); // 뉴스 게시글이 안보일 때 null 발생이 생기니 ofNullable 메서드 사용
    }

    @Override
    public void OptionalInit(String newsNo) {
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
    public List<News> findAll() {
        return repository.findAll();
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
