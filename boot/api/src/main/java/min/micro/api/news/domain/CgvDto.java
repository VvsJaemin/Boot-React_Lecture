package min.micro.api.news.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Component
public class CgvDto {

    private long cgvId;

    private String category;

    private String title;

    private String address;
}
