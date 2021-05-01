package min.micro.api.news.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Component
@Data
public class BugsDto {

    private long bugsId;

    private String category;

    private String title;

    private String address;

}
