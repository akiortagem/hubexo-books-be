package com.hubexo.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hubexo.book.adapter.persistence.jpa.BookRepositoryJpaAdapter;
import com.hubexo.book.adapter.persistence.jpa.repository.SpringDataBookJpaRepository;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.in.HealthCheckUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.application.service.CreateBookService;
import com.hubexo.book.application.service.GetBookService;
import com.hubexo.book.application.service.HealthCheckService;

@Configuration
public class UseCaseConfig {
    @Bean
    HealthCheckUseCase healthCheckUseCase(){
        return new HealthCheckService();
    }

    @Bean
    BookRepositoryPort bookRepositoryPort(SpringDataBookJpaRepository repo){
        return new BookRepositoryJpaAdapter(repo);
    }

    @Bean
    CreateBookUseCase createBookUseCase(BookRepositoryPort repo){
        return new CreateBookService(repo);
    }

    @Bean
    GetBookUseCase getBookUseCase(BookRepositoryPort repo){
        return new GetBookService(repo);
    }
}
