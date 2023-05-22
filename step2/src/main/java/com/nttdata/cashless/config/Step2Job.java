package com.nttdata.cashless.config;

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
public class Step2Job {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Step3Job step3Job;


/*    @Autowired
    private TaskExecutor taskExecutor; // 注入TaskExecutor*/

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step")
                .tasklet((stepContribution, chunkContext) -> {
                    // step2 逻辑
                    System.out.println("=========2222=========Executing Step 2 Logic");
                    Thread.sleep(5000); // 模拟5秒的执行延迟
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

/*    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(step2())
                .next(step3Job.step3()) // 调用 Step3项目的步骤
                .build();
    }*/

}

