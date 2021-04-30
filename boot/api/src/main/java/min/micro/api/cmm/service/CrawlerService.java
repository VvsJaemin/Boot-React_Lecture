package min.micro.api.cmm.service;

import min.micro.api.cmm.domain.Crawler;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    List<?> scrapBugs(Crawler crawler) throws IOException;
}
