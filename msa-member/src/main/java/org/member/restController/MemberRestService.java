package org.member.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.vo.MemberVO;
import org.member.clothController.CQ;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberRestService {

    private final ObjectMapper objectMapper;
    private final MemberRestRepository memberRestRepository;
    private final RestTemplate restTemplate;

    public boolean existsByUsername(String username) {
        return memberRestRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return memberRestRepository.existsByEmail(email);
    }

    public List<Object> viewWeatherAnswer(String url, Object sendingData, List<CQ> clothForQuestionToGPTDTOS, String username) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String requestJson = objectMapper.writeValueAsString(sendingData);
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        List<Object> answerByWeatherList = objectMapper.readValue(response.getBody(), List.class);
            answerByWeatherList.add(clothForQuestionToGPTDTOS);
            answerByWeatherList.add(username);
        return answerByWeatherList;
    }

    public String viewGptAnswer(String url, Object sendingData) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String requestJson = objectMapper.writeValueAsString(sendingData);
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    public String findPasswordByUsername(String username) {
        MemberVO member = memberRestRepository.findByUsername(username);
        if (member != null) {
            return member.getPassword();
        }
        return null;
    }
}
