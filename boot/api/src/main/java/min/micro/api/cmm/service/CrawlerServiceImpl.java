package min.micro.api.cmm.service;

import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.Bugs;
import min.micro.api.news.domain.Cgv;
import min.micro.api.news.domain.News;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Log
public class CrawlerServiceImpl implements CrawlerService {
    public static Document connectUrl(String url) throws IOException {
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
    public List<?> scrapBugs(Crawler crawler) throws IOException {
        Document bugsdocument = connectUrl(crawler.getUrl()); // jsoup 불변객체, "https://news.daum.net/society"
        //List<>
        Elements bugselements = bugsdocument.select(crawler.getCssQuery());
        //"div.sect-movie-chart>ol>li>div.box-image>strong"
        for (int i = 0; i < bugselements.size(); i++) {
            Bugs bugs = new Bugs();
            bugs.setTitle(bugselements.get(i).text());
            bugs.setAddress(bugselements.get(i).attr("href"));
            bugs.setCategory(crawler.getCategory());
        }
//        return repository.count() > 0L ? 1L: 0L;
        return null;
    }

    @Override
    public List<?> scrapNews(Crawler crawler) throws IOException {

        Document document = new Document(crawler.getUrl());
        Elements elements = document.select(crawler.getCssQuery());
        for (int i = 0; i < elements.size(); i++) {
            News news = new News();
            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
        }

        return null;
    }

    @Override
    public List<?> scrapCgv(Crawler crawler) throws IOException {
        Document cgvdocument = new Document(crawler.getUrl()); //http://www.cgv.co.kr/movies/
        Elements cgvelements = cgvdocument.select(crawler.getCssQuery());

        for (int i = 0; i < cgvelements.size(); i++) {
            Cgv cgv = new Cgv();

            cgv.setTitle(cgvelements.get(i).text());
            cgv.setAddress(cgvelements.get(i).attr("href"));
            cgv.setCategory(cgv.getCategory());

        }

        return null;
    }


}
