package min.micro.api.news.service;

import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.Cgv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CgvService {
    public List<Cgv> cgvFindAll();
    public void crawlingHome();
    List<Cgv> saveAll(Crawler crawler) throws Exception;
    Page<Cgv> findAll(final Pageable pageable);
    public Optional<Cgv> findByCgvId(String cgvId);
    public void OptionalInit(String cgvId);
}
