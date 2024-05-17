package org.member;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.member", "org.core"})
public class memberMain {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application,application-dev");
        SpringApplication.run(memberMain.class, args);
    }
}