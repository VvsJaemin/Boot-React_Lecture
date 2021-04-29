package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import min.micro.api.news.service.CgvServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cgv")
@RequiredArgsConstructor
public class CgvController {

    private final CgvServiceImpl service;

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawling(@PathVariable String category) throws Exception {
        service.saveAll(category);
        System.out.println("************카테고리 : " + category);

        return ResponseEntity.ok(service.saveAll(category));
    }

}
