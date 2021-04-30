package min.micro.api.hall.domain;

import min.micro.api.exhibition.domain.Exhibition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private Long hallId;

    @OneToMany(mappedBy = "hall") // 자식에 있는 부모의 조인컬럼 객체 값을 mappeBy해야한다.
    List<Exhibition> exhibitions = new ArrayList<>(); // 일대다는 List 생성
}
