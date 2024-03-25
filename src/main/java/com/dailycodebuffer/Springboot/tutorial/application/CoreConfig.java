package com.dailycodebuffer.Springboot.tutorial.application;

import com.dailycodebuffer.Springboot.tutorial.usecase.circular.CircularRepository;
import com.dailycodebuffer.Springboot.tutorial.usecase.circular.ReadCircularUseCase;
import com.dailycodebuffer.Springboot.tutorial.usecase.identity.GenerateRandomIdentityUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    @Bean
    public GenerateRandomIdentityUseCase generateRandomIdentityUseCase() {
        return new GenerateRandomIdentityUseCase();
    }



    @Bean
    public ReadCircularUseCase readCircularUseCase(CircularRepository repository) {
        return new ReadCircularUseCase(repository);
    }

}
