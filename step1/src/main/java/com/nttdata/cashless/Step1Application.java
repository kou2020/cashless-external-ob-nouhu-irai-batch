package com.nttdata.cashless;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class Step1Application {
    public static void main(String[] args) {
        SpringApplication.run(Step1Application.class, args);
    }
}
