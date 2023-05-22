package com.nttdata.cashless.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class kokkokin {
    @Autowired
    private Step1Job step1Job; // 引入Step1的配置类

    @Autowired
    private Step3Job step3Job; // 引入Step3的配置类

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job customJob() {
        return jobBuilderFactory.get("kokkokin")
                .start(step1Job.step1()) // 执行Step1
                .next(step3Job.step3()) // 执行Step3
                .build();
    }}
