package min.micro.api.review.controller;

import lombok.RequiredArgsConstructor;
import min.micro.api.cmm.controller.AbstractController;
import min.micro.api.review.domain.Review;
import min.micro.api.review.service.ReviewServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class ReviewController extends AbstractController<Review> {

    private final ReviewServiceImpl service;

    @PostMapping("")
    public ResponseEntity<Long> save(Review review) {
        return ResponseEntity.ok(service.save(review));
    }

    @Override
    public ResponseEntity<Optional<Review>> findById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Review>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Long> count() {
        return null;
    }

    @Override
    public ResponseEntity<Review> getOne(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Long> delete(Review review) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> existsById(long id) {
        return null;
    }
}
