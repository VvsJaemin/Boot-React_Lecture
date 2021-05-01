package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.Cgv;
import min.micro.api.news.service.CgvServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cgvs")
@Log
@RequiredArgsConstructor
public class CgvController {

    private final CgvServiceImpl service;

    @PostMapping("/scrap")
    public ResponseEntity<List<Cgv>> crawling(@RequestBody Crawler crawler) throws Exception {
        System.out.println("************카테고리 : " + crawler.toString());
        return ResponseEntity.ok(service.saveAll(crawler));
    }

    @GetMapping("")
    public ResponseEntity<Page<Cgv>> retrieve(final Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

}
