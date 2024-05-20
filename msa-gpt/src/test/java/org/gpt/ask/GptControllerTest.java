package org.gpt.ask;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.gpt.GptanswervoDto;
import org.gpt.saveAnswer.SaveAnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class GptControllerTest {

    @MockBean
    private GptService gptService;

    @MockBean
    private SaveAnswerService saveAnswerService;

    private List<Object> questionData;
    private String dustData;
    private String weatherData;
    private String clothData;
    private String username;
    private String question;
    private String answer;
    private GptanswervoDto gptanswervoDto;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        dustData = "오늘의 미세먼지";
        weatherData = "오늘의 날씨";
        clothData = "옷 데이터";
        username = "유저이름";

        questionData = new ArrayList<>();
            questionData.add(dustData);
            questionData.add(weatherData);
            questionData.add(clothData);
            questionData.add(username);

        question =  "오늘의 날씨: " + weatherData +
                    " 오늘의 미세먼지: " + dustData +
                    " 옷 데이터: " + clothData;
        answer = "[{\"상의\":\"화이트 심플한 캐주얼한 티셔츠\",\"하의\":\"진청 데일리한 청바지\",\"양말\":\"화이트 베이직한 스니커즈 양말\",\"신발\":\"화이트 심플한 캔버스 스니커즈\"},{\"미세먼지(PM10)\":\"보통 (48)\",\"초미세먼지(PM2.5)\":\"좋음 (15)\",\"마스크 착용 여부\":\"필수\"}]";
        gptanswervoDto = new GptanswervoDto(username, question, answer);
    }

    @Test
    void askToGpt() throws Exception {
        //Given
        BDDMockito  .doNothing()
                    .when(saveAnswerService)
                    .saveAnswer(gptanswervoDto);

        MultiValueMap<String, String> questionData = new LinkedMultiValueMap<>();
            questionData.add("dustData", dustData);
            questionData.add("username", username);
            questionData.add("question", question);
            questionData.add("answer", answer);

        //When & Then
        mockMvc.perform(post("/askToGpt").params(questionData))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value(answer));
    }

}