package com.hubexo.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hubexo.book.application.port.in.HealthCheckUseCase;
import com.hubexo.book.application.service.HealthCheckService;

@Configuration
public class UseCaseConfig {
    @Bean
    HealthCheckUseCase healthCheckUseCase(){
        return new HealthCheckService();
    }
}
