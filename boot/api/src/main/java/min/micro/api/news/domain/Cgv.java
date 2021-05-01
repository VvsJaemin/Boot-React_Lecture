package min.micro.api.news.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Cgv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cgvId;

    @Column(length = 20, nullable = true)
    private String category;

    @Column(length = 512, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String address;
}
