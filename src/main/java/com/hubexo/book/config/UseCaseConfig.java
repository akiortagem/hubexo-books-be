package com.hubexo.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hubexo.book.adapter.persistence.jpa.BookRepositoryJpaAdapter;
import com.hubexo.book.adapter.persistence.jpa.repository.SpringDataBookJpaRepository;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.in.DeleteBookUseCase;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.in.HealthCheckUseCase;
import com.hubexo.book.application.port.in.ListBooksUseCase;
import com.hubexo.book.application.port.in.UpdateBookUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.application.service.CreateBookService;
import com.hubexo.book.application.service.DeleteBookService;
import com.hubexo.book.application.service.GetBookService;
import com.hubexo.book.application.service.HealthCheckService;
import com.hubexo.book.application.service.ListBooksService;
import com.hubexo.book.application.service.UpdateBookService;

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

    @Bean
    ListBooksUseCase listBooksUseCase(BookRepositoryPort repo){
        return new ListBooksService(repo);
    }

    @Bean
    DeleteBookUseCase deleteBookUseCase(BookRepositoryPort repo){
        return new DeleteBookService(repo);
    }

    @Bean
    UpdateBookUseCase updateBookUseCase(BookRepositoryPort repo){
        return new UpdateBookService(repo);
    }
}
