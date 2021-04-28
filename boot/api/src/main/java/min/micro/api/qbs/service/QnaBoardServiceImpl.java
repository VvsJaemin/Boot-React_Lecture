package min.micro.api.qbs.service;


import lombok.AllArgsConstructor;
import min.micro.api.cmm.service.AbstractService;
import min.micro.api.qbs.domain.QnaBoard;
import min.micro.api.qbs.repository.QnaBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QnaBoardServiceImpl extends AbstractService<QnaBoard> implements QnaBoardService {

    private final QnaBoardRepository repo;


    @Override
    public QnaBoard save(QnaBoard entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<QnaBoard> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<QnaBoard> findAll() {
        return repo.findAll();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public QnaBoard getOne(long id) {
        return repo.getOne(id);
    }

    @Override
    public Long delete(QnaBoard qnaBoard) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return false;
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
