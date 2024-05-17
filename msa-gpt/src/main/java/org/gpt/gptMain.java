package org.gpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class gptMain {

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "application,application-dev");
        SpringApplication.run(gptMain.class, args);
    }
}