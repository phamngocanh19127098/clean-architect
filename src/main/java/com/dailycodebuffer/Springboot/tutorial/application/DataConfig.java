package com.dailycodebuffer.Springboot.tutorial.application;

import com.dailycodebuffer.Springboot.tutorial.infrastructure.CircularJPARepository;
import com.dailycodebuffer.Springboot.tutorial.infrastructure.CircularRepositoryImpl;
import com.dailycodebuffer.Springboot.tutorial.usecase.circular.CircularRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public CircularRepository circularRepository(CircularJPARepository circularEntityRepository) {
        return new CircularRepositoryImpl(circularEntityRepository);
    }
}
