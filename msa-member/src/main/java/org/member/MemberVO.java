package org.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "membervo")
public class MemberVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('membervo_userid_seq'")
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    @Email
    private String email;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @NotNull
    @Column(name = "registerdate")
    private Instant registerdate;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", length = 50)
    private String country;

    @Size(max = 50)
    @NotNull
    @Column(name = "area", length = 50)
    private String area;

}