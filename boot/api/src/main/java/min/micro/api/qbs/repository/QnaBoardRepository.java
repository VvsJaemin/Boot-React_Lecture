package min.micro.api.qbs.repository;

import min.micro.api.qbs.domain.QnaBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoard, Long> {


}
