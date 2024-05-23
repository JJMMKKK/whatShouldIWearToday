package org.member.mailController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String fromEmail, String toEmail, String emailTitle, String emailBody, String innerImageName, String innerImagePath) {
        mailSender.send(
                mimeMessage -> {
                    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);                // true: 멀티파트 메세지를 사용
                    messageHelper.setFrom(fromEmail);
                    messageHelper.setTo(toEmail);
                    messageHelper.setSubject(emailTitle);
                    messageHelper.setText(emailBody, true);                                                        // true: html을 사용
                    messageHelper.addInline(innerImageName, new ClassPathResource(innerImagePath));
                });
    }

    public String emailBody(String emailForm, Map<String, String> changeData) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(emailForm);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));

        String line;
        StringBuilder email_body = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            for (Map.Entry<String, String> entry : changeData.entrySet()) {
                line = line.replace(entry.getKey(), entry.getValue());
            }
            email_body.append(line);
            email_body.append("\n");
        }
        return email_body.toString();
    }

}
