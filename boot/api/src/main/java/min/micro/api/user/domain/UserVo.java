package min.micro.api.user.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique=true, nullable=false)
    private String username;
    @Size(min=8, message="Minimum Password Length: 8characters")
    private String password;
    @Column(unique=true, nullable=false)
    private String email;
    @Column(unique=true, nullable=false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER) // 속성이 컬렉션을 저장 할것이라고 설정, 컬렉션의 저장될 정보는 별도의 테이블에 존재
    List<Role> roles;

}