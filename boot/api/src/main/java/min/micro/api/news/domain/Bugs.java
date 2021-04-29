package min.micro.api.news.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Bugs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bugsId;

    @Column(length = 20, nullable = false)
    private String titleNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 512, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String address;

    @Builder
    public Bugs(String newsNo, String category, String title, String address) {
        this.titleNo = newsNo;
        this.category = category;
        this.title = title;
        this.address = address;
    }
}
