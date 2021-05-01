package min.micro.api.news.service;

import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.Bugs;
import min.micro.api.news.domain.Cgv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface BugsService {

    public List<Bugs> bugsFindAll();

    public void crawlingHome();

    List<Bugs> saveAll(Crawler crawler) throws Exception;

    Page<Bugs> findAll(final Pageable pageable);

    public Optional<Bugs> findByBugsId(String bugsId);

    public void OptionalInit(String bugsId);

}
