package org.gpt.ask;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gpt.GptanswervoDto;
import org.gpt.saveAnswer.SaveAnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Slf4j
@Controller
public class GptController {

    private final GptService gptService;
    private final SaveAnswerService saveAnswerService;

    @ResponseBody
    @PostMapping("/askToGpt")
    public String askToGpt(String question) throws JsonProcessingException {

        String username = "qwe";
        String answer = gptService.getGptResponse(question);

        GptanswervoDto gptanswervoDto = new GptanswervoDto(username, question, answer);
        saveAnswerService.saveAnswer(gptanswervoDto);

        return answer;
    }

    @GetMapping("/gptMain")
    public String gptMain() {
        return "GptMain";
    }

}
