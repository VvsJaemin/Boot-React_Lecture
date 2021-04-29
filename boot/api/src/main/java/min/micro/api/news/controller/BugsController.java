package min.micro.api.news.controller;

import lombok.RequiredArgsConstructor;
import min.micro.api.news.service.BugsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bugs")
public class BugsController {

    private final BugsServiceImpl service;

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawling(@PathVariable String category) throws  Exception{
        service.saveAll(category);

        System.out.println("************카테고리 : " + category);
        return ResponseEntity.ok(service.saveAll(category));
    }
}
