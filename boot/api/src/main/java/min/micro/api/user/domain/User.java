package min.micro.api.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "members")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_no")
    private long userNo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="name") private String name;

    @Email
    @Column(name="email") private String email;

    @Column(name="birthday") private String birthday;

    @Column(name="gender") private String gender;

    public User toEntity() {
        return User.builder()
                .userNo(userNo)
                .password(password)
                .username(username)
                .name(name)
                .email(email)
                .birthday(birthday)
                .gender(gender)
                .build();

    }

    @Builder
    public User(long userNo, String username, String password, String name,
                @Email String email, String birthday, String gender) {
        this.userNo = userNo;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }




}