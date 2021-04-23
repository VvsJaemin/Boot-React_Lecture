package min.micro.api.qbs.service;


@Service
@AllArgsConstructor
public class QnaBoardServiceImpl extends AbstractService<QnaBoard> implements QnaBoardService {

    private final QnaBoardRepository repo;


    @Override public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override public List<QnaBoard> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override public Optional<QnaBoard> findOne() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override public QnaBoard getOne(long id) {
        // TODO Auto-generated method stub
        return repo.getOne(id);
    }

    @Override public QnaBoard save(QnaBoard entity) {
        // TODO Auto-generated method stub
        return repo.save(entity);
    }

    @Override public Optional<QnaBoard> findById(long id) {

        return repo.findById(id);
    }



}
