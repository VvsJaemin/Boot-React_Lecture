package min.micro.api.qbs.domain;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "qnas")
public class QnaBoard {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
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


    @Builder
    public QnaBoard(long boardNo, String title, String writer, String content, Date regDate) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;

    }






}