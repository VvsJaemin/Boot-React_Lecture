package min.micro.api.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.news.domain.Bugs;
import min.micro.api.news.domain.Cgv;
import min.micro.api.news.repository.CgvRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log
@Lazy
public class CgvServiceImpl extends AbstractService<Cgv> implements CgvService {

    private final CgvRepository repository;

    @Override
    public Document connectUrl(String url) throws IOException {
        log.info("connectUrl()" + url);

        return Jsoup.connect(url)
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute().parse();
    }

    @Override
    public Long saveAll(String category) throws IOException {
        Document cgvdocument = connectUrl("http://www.cgv.co.kr/" + category);
        repository.deleteAll();
        Elements cgvelements = cgvdocument.select("div.sect-movie-chart>ol>li>div.box-image>strong");

        int count = 0;
        for (int i = 0; i < cgvelements.size(); i++) {
            Bugs bugs = new Bugs();

            bugs.setTitle(cgvelements.get(i).text());
            bugs.setAddress(cgvelements.get(i).attr("href"));
            bugs.setCategory(category);

            count++;

            System.out.println("************** News 정보" + bugs.toString());
        }
        System.out.println("************** 크롤링 카운트" + count);
        return 0L;
    }

    @Override
    public Optional<Cgv> findByCgvNo(String titleNo) {
        Optional.ofNullable(repository.findByCgvNo(titleNo)).ifPresent(System.out::println);
        return Optional.ofNullable(repository.findByCgvNo(titleNo));
    }

    @Override
    public Long save(Cgv cgv) {
        return null;
    }

    @Override
    public Optional<Cgv> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Cgv> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Optional<Cgv> getOne(long id) {
        return Optional.empty();
    }

    @Override
    public Long delete(Cgv cgv) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }



    @Override
    public List<Cgv> cgvFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }


    @Override
    public void OptionalInit(String titleNo) {

    }
}
