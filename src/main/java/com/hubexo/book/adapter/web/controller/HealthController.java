package com.hubexo.book.adapter.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubexo.book.application.dto.HealthStatus;
import com.hubexo.book.application.port.in.HealthCheckUseCase;

@RestController
public class HealthController {
    private final HealthCheckUseCase healthCheck;

    public HealthController(HealthCheckUseCase healthCheck){
        this.healthCheck = healthCheck;
    }

    @GetMapping("/healthz")
    public HealthStatus healthz(){
        return healthCheck.check();
    }
}
