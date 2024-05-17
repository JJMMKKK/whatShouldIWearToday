package org.member.configuration;

import lombok.RequiredArgsConstructor;
import org.core.kafka.KafkaConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class MemberConfiguration {

    private final KafkaConsumerConfig consumerConfig;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
