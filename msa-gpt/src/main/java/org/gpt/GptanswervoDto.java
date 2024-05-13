package org.gpt;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Gptanswervo}
 */
@Data
@Value
public class GptanswervoDto implements Serializable {

    @NotNull
    @Size(max = 50)
    String username;

    @NotNull
    @Size(max = 50000)
    String question;

    @NotNull
    @Size(max = 50000)
    String answer;
}