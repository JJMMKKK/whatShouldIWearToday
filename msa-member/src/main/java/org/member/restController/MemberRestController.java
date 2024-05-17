package org.member.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.WeatherareavoDTO;
import org.member.CQ;
import org.member.clothController.ClothController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberRestService memberRestService;
    private final RestTemplate restTemplate;
    private final ClothController clothController;

    @PostMapping("AjaxExistByUsername")
    public boolean ajaxExistByUsername(String username) {
        return memberRestService.existsByUsername(username);
    }

    @PostMapping("AjaxExistByEmail")
    public boolean ajaxExistByEmail(String email) {
        return memberRestService.existsByEmail(email);
    }

    @PostMapping("viewGptAnswer")
    public String viewGptAnswer(WeatherareavoDTO weatherareavoDTO, Integer userid) {
        List<CQ> clothForQuestionToGPTDTOS = clothController.selectClothDataForQuestionToGPT(userid);
        String url = "http://localhost:9002/selectWeatherDataForQuestionToGPT";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<WeatherareavoDTO> requestEntity = new HttpEntity<>(weatherareavoDTO, headers);

        ResponseEntity<List> response = restTemplate.postForEntity(url, requestEntity, List.class);
        log.info(Objects.requireNonNull(response.getBody()).toString());

        return null;
    }

}
