package min.micro.api.address;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue

    @Column(name = "address_id")
    private long addressId;
    @Column(name = "name")
    private String name;
    @Column(name = "addr")
    private String addr;
    @Column(name = "rdate")
    private Date rdate;

}
