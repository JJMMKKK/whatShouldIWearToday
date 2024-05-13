package org.gpt.ask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GptConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
