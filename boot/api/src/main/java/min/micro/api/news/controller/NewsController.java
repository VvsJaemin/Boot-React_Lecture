package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.news.domain.News;
import min.micro.api.news.service.NewsService;
import min.micro.api.news.service.NewsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsServiceImpl service;

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawling(@PathVariable String category) throws Exception{
        service.saveAll(category);
        System.out.println("************카테고리 : " + category);
        return ResponseEntity.ok(service.saveAll(category));
    }
}
