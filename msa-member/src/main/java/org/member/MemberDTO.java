package org.member;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * {@link MemberVO}와 관련된 DTO
 */
@Value
public class MemberDTO implements Serializable {
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
