package com.example.application;

import com.example.infrastructure.CircularJPARepository;
import com.example.infrastructure.CircularRepositoryImpl;
import com.example.usecase.circular.CircularRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public CircularRepository circularRepository(CircularJPARepository circularEntityRepository) {
        return new CircularRepositoryImpl(circularEntityRepository);
    }
}
