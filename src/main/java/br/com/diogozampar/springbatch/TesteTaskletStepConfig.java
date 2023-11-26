package br.com.diogozampar.springbatch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;




@Configuration
public class TesteTaskletStepConfig {
    

    @Bean
    public Step testeTaskletStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("step", jobRepository)
            .tasklet((StepContribution stepContribution, ChunkContext chunkContext) -> {
            System.out.println("Teste tasklet Spring Batch v5");
            return RepeatStatus.FINISHED;
        }, platformTransactionManager)
        .build();
    }



}
