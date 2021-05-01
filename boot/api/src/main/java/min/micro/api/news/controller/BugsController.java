package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.cmm.domain.Crawler;
import min.micro.api.news.domain.Bugs;
import min.micro.api.news.repository.BugsRepository;
import min.micro.api.news.service.BugsService;
import min.micro.api.news.service.BugsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bugs")
@Log
public class BugsController {

    private final BugsServiceImpl service;

    @PostMapping("/scrap")
    public ResponseEntity<List<Bugs>> crawling(@RequestBody Crawler crawler) throws Exception{

        return ResponseEntity.ok(service.saveAll(crawler));
    }

    @GetMapping("")
    public ResponseEntity<Page<Bugs>> retrieve(final Pageable pageable){

        return ResponseEntity.ok(service.findAll(pageable));
    }
}
