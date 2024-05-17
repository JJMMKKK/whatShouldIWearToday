package org.member.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.dto.WeatherareavoDTO;
import org.member.CQ;
import org.member.clothController.ClothController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberRestService memberRestService;
    private final ClothController clothController;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("AjaxExistByUsername")
    public boolean ajaxExistByUsername(String username) {
        return memberRestService.existsByUsername(username);
    }

    @PostMapping("AjaxExistByEmail")
    public boolean ajaxExistByEmail(String email) {
        return memberRestService.existsByEmail(email);
    }

    @PostMapping("/viewGptAnswer")
    public List viewGptAnswer(WeatherareavoDTO weatherareavoDTO, Integer userid, String username) throws JsonProcessingException {

        List<CQ> clothForQuestionToGPTDTOS = clothController.selectClothDataForQuestionToGPT(userid);

        String weatherUrl = "http://localhost:9002/selectWeatherDataForQuestionToGPT";
        List<Object> answerByWeatherList = memberRestService.viewWeatherAnswer(weatherUrl, weatherareavoDTO, clothForQuestionToGPTDTOS, username);

        String gptUrl = "http://localhost:9003/askToGpt";
        String answerByGpt = memberRestService.viewGptAnswer(gptUrl, answerByWeatherList);
        return objectMapper.readValue(answerByGpt, List.class);
    }

    @PostMapping("/loginAjax")
    public boolean loginAjax(String username, String password) {

        String encodedPassword = memberRestService.findPasswordByUsername(username);
        if(encodedPassword == null || encodedPassword.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(password, encodedPassword);
    }
}
