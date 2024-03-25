package com.example.application;

import com.example.usecase.circular.CircularRepository;
import com.example.usecase.circular.ReadCircularUseCase;
import com.example.usecase.identity.GenerateRandomIdentityUseCase;

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
