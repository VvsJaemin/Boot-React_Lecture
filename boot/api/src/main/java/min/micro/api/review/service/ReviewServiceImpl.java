package min.micro.api.review.service;

import lombok.RequiredArgsConstructor;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.review.domain.Review;
import min.micro.api.review.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends AbstractService<Review> implements ReviewService {

    private final ReviewRepository repository;


    @Override
    public Long save(Review review) {
        return (repository.save(review) != null) ? 1L : 0L;
    }

    @Override
    public Optional<Review> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Optional<Review> getOne(long id) {
        return null;
    }

    @Override
    public Long delete(Review review) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
