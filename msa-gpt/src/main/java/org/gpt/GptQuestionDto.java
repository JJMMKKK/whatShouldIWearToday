package org.gpt;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * model: 사용할 모델
 * prompt: 질문
 * temperature: 창의성(1일수록 높음)
 * max_tokens: 최대 사용 토큰
 */

@Data
@Value
public class GptQuestionDto implements Serializable {

    @NotNull
    @Size(max = 50)
    String model = "gpt-3.5-turbo";

    @NotNull
    @Size(max = 50000)
    String prompt;

    @NotNull
    float temperature = 1.0F;

    @NotNull
    int max_tokens = 200;
}