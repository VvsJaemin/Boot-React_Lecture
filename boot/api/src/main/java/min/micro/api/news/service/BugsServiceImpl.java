package min.micro.api.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.cmm.service.CrawlerServiceImpl;
import min.micro.api.news.domain.Bugs;
import min.micro.api.news.repository.BugsRepository;
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
public class BugsServiceImpl implements BugsService {

    private final BugsRepository repository;

    @Override
    public List<Bugs> bugsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }

    @Override
    public List<Bugs> saveAll(Crawler crawler) throws Exception {
        Document document = CrawlerServiceImpl.connectUrl(crawler.getUrl());
        repository.deleteAll();

        Elements elements = document.select(crawler.getCssQuery());

        List<Bugs> bugsList = new ArrayList<>();

        for(int i = 0; i<bugsList.size(); i++){
            Bugs bugs = new Bugs();
            bugs.setTitle(elements.get(i).text());
            bugs.setAddress(elements.get(i).attr("href"));
            bugs.setCategory(crawler.getCategory());
            bugsList.add(bugs);
            repository.save(bugs);
        }
        return bugsList;
    }

    @Override
    public Page<Bugs> findAll(Pageable pageable) {

        return null;
    }

    @Override
    public Optional<Bugs> findByBugsId(String bugsId) {
        return Optional.empty();
    }

    @Override
    public void OptionalInit(String bugsId) {

    }
}
