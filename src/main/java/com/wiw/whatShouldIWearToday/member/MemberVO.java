package com.wiw.whatShouldIWearToday.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@Getter
@Setter
@Entity                         //JPA가 관리하는 클래스
@Table(name = "membervo")       //테이블과 매핑할 테이블은 해당 어노테이션을 붙임
public class MemberVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('users_userid_seq'")
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
    @Column(name = "registerdate")
    @DateTimeFormat
    private Instant registerdate;

}