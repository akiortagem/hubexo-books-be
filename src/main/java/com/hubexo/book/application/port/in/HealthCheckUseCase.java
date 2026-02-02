package com.hubexo.book.application.port.in;

import com.hubexo.book.application.dto.HealthStatus;

public interface HealthCheckUseCase {
    HealthStatus check();
}
