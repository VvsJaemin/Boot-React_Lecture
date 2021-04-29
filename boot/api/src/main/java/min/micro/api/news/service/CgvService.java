package min.micro.api.news.service;

import min.micro.api.news.domain.Bugs;
import min.micro.api.news.domain.Cgv;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CgvService {


    public Document connectUrl(String url) throws IOException;
    public List<Cgv> cgvFindAll();
    //    public List<HomeNews> homeNewsFindAll();
    public void crawlingHome() ;
    Long saveAll(String category) throws IOException;
    public Optional<Cgv> findByCgvNo(String titleNo);
    public void OptionalInit(String titleNo);
//    public ClickedNews crawlingOne(String newsNo);
}
