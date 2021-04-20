package min.micro.api.file;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FileVo {

    @Id
    @GeneratedValue

    @Column(name = "file_id")
    private long fileId;

    @Column(name = "save_fname")
    private String saveFname;

    @Column(name = "origin_fname")
    private String originFname;

    @Column(name = "fsize")
    private long fsize;


}
