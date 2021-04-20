package min.micro.api.file;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileDto {

    private long fileId;

    private String saveFname;

    private String originFname;

    private long fsize;
}
