package com.wiw.whatShouldIWearToday.member;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link MemberVO}
 */
@Value
public class MemberVODto implements Serializable {
    @Size(max = 50)
    @NotBlank(message = "아이디를 입력하세요")
    String username;

    @Size(max = 100)
    @NotBlank(message = "비밀번호를 입력하세요")
    String password;

    @Size(max = 100)
    @Email(message = "올바른 이메일 형식이 아닙니다")
    @NotBlank(message = "이메일을 입력하세요")
    String email;
}
