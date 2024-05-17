package org.member.restController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

@Data
@Value
public class LoginRequestDTO {
    @Size(max = 50)
    @NotBlank(message = "아이디를 입력하세요")
    String username;

    @Size(max = 100)
    @NotBlank(message = "비밀번호를 입력하세요")
    String password;
}
