package min.micro.api.feed.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name="feeds")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feed_no")
    private long feedNo;

    @Column(name="title")
    private String title;

    @Column(name="writer")
    private String writer;

    @Column(name="content")
    private String content;

    @Column(name="add_location")
    private String addLocation;

    @Column(name="hash_tag")
    private String hashTag;

    @Column(name = "reg_date")
    private Date regDate = new Date();
}
