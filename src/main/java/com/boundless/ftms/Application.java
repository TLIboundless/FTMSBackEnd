package com.boundless.ftms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.boundless.ftms")
@SpringBootApplication

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
