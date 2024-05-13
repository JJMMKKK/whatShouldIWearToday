package org.gpt.saveAnswer;

import lombok.RequiredArgsConstructor;
import org.gpt.Gptanswervo;
import org.gpt.GptanswervoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveAnswerService {

    public final SaveAnswerRepository saveAnswerRepository;

    public void saveAnswer(GptanswervoDto gptanswervoDto) {
        Gptanswervo gptanswervo = new Gptanswervo();
        BeanUtils.copyProperties(gptanswervoDto, gptanswervo);
        saveAnswerRepository.save(gptanswervo);
    }
}
