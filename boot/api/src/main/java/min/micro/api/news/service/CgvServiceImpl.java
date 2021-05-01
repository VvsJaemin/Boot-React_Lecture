package min.micro.api.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.cmm.service.CrawlerServiceImpl;
import min.micro.api.news.domain.Cgv;
import min.micro.api.news.repository.CgvRepository;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
@Log
public class CgvServiceImpl extends CrawlerServiceImpl implements CgvService {

    private final CgvRepository repository;

    @Override
    public List<Cgv> cgvFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }

    @Override
    public List<Cgv> saveAll(Crawler crawler) throws Exception {
        Document document = CrawlerServiceImpl.connectUrl(crawler.getUrl());
        repository.deleteAll();

        Elements elements = document.select(crawler.getCssQuery());

        List<Cgv> cgvlist = new ArrayList<>();

        for(int i =0; i<cgvlist.size(); i++){
            Cgv cgv = new Cgv();
            cgv.setTitle(elements.get(i).text());
            cgv.setAddress(elements.get(i).attr("href"));
            cgv.setCategory(crawler.getCategory());
            cgvlist.add(cgv);
            repository.save(cgv);
        }

        return cgvlist;
    }

    @Override
    public Page<Cgv> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Cgv> findByCgvId(String cgvId) {
        return Optional.empty();
    }

    @Override
    public void OptionalInit(String cgvId) {

    }
}
