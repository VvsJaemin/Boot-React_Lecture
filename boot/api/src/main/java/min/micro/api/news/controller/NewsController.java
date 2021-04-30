package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.News;
import min.micro.api.news.service.NewsService;
import min.micro.api.news.service.NewsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsServiceImpl service;

    @PostMapping ("/scrap")
    public ResponseEntity<List<News>> crawling(@RequestBody Crawler crawler) throws Exception{
        System.out.println("************카테고리 : " + crawler.toString());
        return ResponseEntity.ok(service.saveAll(crawler)); //무상태로 만들기위해  -> 랩핑 된걸 받는 사람은 ok만 나오고 토큰을 통해 실제 값을 봐야한다.
    }

    @PostMapping
    public ResponseEntity<Long> post(@RequestBody News news) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<Page<News>>retrieve(final Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PutMapping
    public ResponseEntity<Long>update(@RequestBody News news){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Long>delete(@RequestBody News news){
        return ResponseEntity.ok(null);
    }
}
