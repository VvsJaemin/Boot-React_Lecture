package min.micro.api.sale_items.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "sale_items")
public class sale_items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_no")
    private long itemNo;

    @Column(name="item_picture")
    private String itemPicture;

    @Column(name="hash_tag")
    private String hashTag;

    @Column(name="title")
    private String title;

    @Column(name="writer")
    private String writer;

    @Column(name="content")
    private String content;

    @Column(name="price")
    private String price;

    @Column(name="sold_out")
    private Boolean soldOut;

    @Column(name="reg_date")
    private String regDate;

}
