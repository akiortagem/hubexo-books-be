package com.hubexo.book.application.service;

import com.hubexo.book.application.dto.HealthStatus;
import com.hubexo.book.application.port.in.HealthCheckUseCase;

public class HealthCheckService implements HealthCheckUseCase {
    @Override
    public HealthStatus check(){
        return new HealthStatus("ok");
    }
    
}
