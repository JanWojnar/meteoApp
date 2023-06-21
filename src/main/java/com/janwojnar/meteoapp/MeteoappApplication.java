package com.janwojnar.meteoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MeteoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteoappApplication.class, args);
    }

}
