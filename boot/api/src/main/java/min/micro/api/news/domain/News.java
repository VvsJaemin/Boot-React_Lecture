package min.micro.api.news.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long newsId;

    @Column(length = 20, nullable = true)
    private String category;

    @Column(length = 512, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String address;

    @Builder
    public News(String category,
                String title, String address) {
    ;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}