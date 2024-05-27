package org.member.mailController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MailController {

    @Value("${spring.mail.username}")
    private static String from;
    private final MailService mailService;

    private static final String from_email = from;
    private String expiredTime;
    private String authorizationCode;

    @PostMapping("/authorizationCode_Email")
    public void authorizationCode_Email(String to_email) throws IOException {

        Map<String,String> changeData = new HashMap<>();

        //******************복사 후 수정하는 부분******************
        String emailCode = "authorizationCode_Email";
        String email_title = "[회원가입인증] 회원가입 인증번호 전송";
        changeData.put("##인증번호##", authorizationCode);              //임시 인증번호
        changeData.put("##인증번호_유효기간##", expiredTime);      //임시 인증번호 유효기간
        //******************복사 후 수정하는 부분******************

        String email_Form = "static/mailForm/"+emailCode+"_Form.html";
        String innerImageName = emailCode+"_Image";
        String innerImagePath = "/static/mailForm/image/"+innerImageName+".png";

        String email_body = mailService.emailBody(email_Form, changeData);
        mailService.sendEmail(from_email, to_email, email_title, email_body, innerImageName, innerImagePath);
    }


    public void temporaryPassword_Email(String to_email, String temporaryPassword, String username) throws IOException {

        Map<String,String> changeData = new HashMap<>();

        //******************복사 후 수정하는 부분******************
        String emailCode = "temporaryPassword_Email";
        String email_title = "[회원정보변경] 임시 비밀번호 발급";
        changeData.put("##유저_링크##", "www.naver.com");           //임시 링크
        changeData.put("##유저_아이디##", username);
        changeData.put("##유저_비밀번호##", temporaryPassword);
        //******************복사 후 수정하는 부분******************

        String email_Form = "static/mailForm/"+emailCode+"_Form.html";
        String innerImageName = emailCode+"_Image";
        String innerImagePath = "/static/mailForm/image/"+innerImageName+".png";

        String email_body = mailService.emailBody(email_Form, changeData);
        mailService.sendEmail(from_email, to_email, email_title, email_body, innerImageName, innerImagePath);

    }

    @PostMapping("/mailCookie")
    public void mailCookie(HttpServletResponse httpServletResponse){

        authorizationCode = "111111";
        int authorialTime = 180;

        LocalDateTime now = LocalDateTime.now();
        expiredTime = now.plus(Duration.ofSeconds(authorialTime)).toString();

        Cookie cookie = new Cookie("authorizationCode", authorizationCode);
            cookie.setMaxAge(authorialTime);
            httpServletResponse.addCookie(cookie);
    }

    @PostMapping("/checkAuthorizationCode")
    public boolean checkAuthorizationCode(String enteredCode){
        return authorizationCode.equals(enteredCode);
    }

    @PostMapping("/deleteAuthorizataionCodeCookiee")
    public void deleteAuthorizataionCodeCookiee(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("authorizationCode", "");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
}
