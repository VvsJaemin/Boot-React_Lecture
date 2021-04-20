package min.micro.api.address;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class AddressDto {


    private long addressId;
    private String name;
    private String addr;
    private Date rdate;

}
