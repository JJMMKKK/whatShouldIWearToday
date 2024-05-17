//package org.member.legacy;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//
//@Data
//public class NotUseMemberDataDTO {
//
//    @NotNull
//    Integer id;
//
//    @Size(max = 50)
//    @NotBlank(message = "아이디를 입력하세요")
//    String username;
//
//    @Size(max = 100)
//    @Email(message = "올바른 이메일 형식이 아닙니다")
//    @NotBlank(message = "이메일을 입력하세요")
//    String email;
//
//    @Size(max = 50)
//    @NotBlank(message = "지역을 입력하세요")
//    String country;
//
//    @Size(max = 50)
//    @NotBlank(message = "위치를 입력하세요")
//    String area;
//}
