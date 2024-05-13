package org.gpt.ask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gpt.GptQuestionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class GptService {

    @Value("${openai.secret-key}")
    private String secretKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public String getGptResponse(String question) throws JsonProcessingException {

        GptQuestionDto questionDto = new GptQuestionDto(question);
            log.info("Gpt question: {}", questionDto);

        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(secretKey);
            headers.add("Content-Type", "application/json");

        Map<String, Object> map = new HashMap<>();
            map.put("model", questionDto.getModel());
            map.put("messages", Collections.singletonList(Map.of("role", "user", "content", questionDto.getPrompt())));
            map.put("temperature", questionDto.getTemperature());
            map.put("max_tokens", questionDto.getMax_tokens());

        //JSON생성
        String requestJson = objectMapper.writeValueAsString(map);

        //HttpEntity 객체 생성
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        
        //ChatGPT에서 받은 json 데이터 출력
        //log.info("Gpt response: {}", response);

        //ChatGPT에서 받은 json 데이터 중 답변만 출력
        JsonNode node = objectMapper.readTree(response.getBody());
        String content = node.path("choices").get(0).path("message").path("content").asText();
        log.info("Gpt response: {}", content);

        return content;
    }
}
