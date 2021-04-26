package min.micro.api.qbs.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "qnas")
public class QnaBoard {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "board_no")
    private long boardNo;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "writer")
    private String writer;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "reg_date")
    private Date regDate = new Date();

    @Column(name = "comments")
    private String comments;


    @Builder
    public QnaBoard(long boardNo, String title, String writer, String content, Date regDate, String comments) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.comments=comments;

    }


}