package min.micro.api.exhibition.domain;

import min.micro.api.hall.domain.Hall;

import javax.persistence.*;

@Entity
@Table(name="exhibitions")
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exhibitions")
    private Long exhibitonId;

    @ManyToOne
    @JoinColumn(columnDefinition = "hall_id") // 부모의 컬럼 값을 조인한다.
    Hall hall; // 단방향 - 부모는 건드리지 않는다. 조인컬럼 객체(실제 값이 들어가 있는 상태) - 주인 - 부모


}
