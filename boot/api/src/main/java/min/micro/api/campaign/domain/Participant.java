package min.micro.api.campaign.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participant_no")
    private long participantNo;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="birthday")
    private String birthday;

    @Column(name="reg_date")
    private String regdate;
}
