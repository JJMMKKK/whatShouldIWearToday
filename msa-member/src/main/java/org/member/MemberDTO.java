package org.member;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.core.vo.MemberVO;

import java.io.Serializable;
import java.time.Instant;

/**
 * {@link MemberVO}와 관련된 DTO
 */
@Data
public class MemberDTO implements Serializable {
    @NotNull
    Integer id;

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

    @NotBlank(message = "가입일이 입력되지 않았습니다")
    Instant registerdate;

    @Size(max = 50)
    @NotBlank(message = "지역을 입력하세요")
    String country;

    @Size(max = 50)
    @NotBlank(message = "위치를 입력하세요")
    String area;
}
