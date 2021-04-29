package min.micro.api.news.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CgvDto {

    private Long cgvId;

    private String titleNo;

    private String category;

    private String title;

    private String address;
}
