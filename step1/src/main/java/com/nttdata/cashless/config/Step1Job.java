package com.nttdata.cashless.config;

import com.nttdata.cashless.service.CheckService;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class Step1Job {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Step3Job step3Job; // 注入Step3的引用

    @Autowired
    private CheckService checkService;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    // Step1的逻辑
                    System.out.println("—————————11111—————————————Executing Step 1 Logic");
                    checkService.TestCommonServiceFunction();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step3Job.step3())
//                .build();
//    }

}


