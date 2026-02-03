package com.hubexo.book.application.service;

import java.util.Objects;
import java.util.UUID;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.CreateBookParams;
import com.hubexo.book.application.port.in.BookValidationUseCase;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.domain.Book;

public class CreateBookService implements CreateBookUseCase {
    private final BookRepositoryPort repo;
    private final BookValidationUseCase validator;

    public CreateBookService(BookRepositoryPort repo, BookValidationUseCase validator){
        this.repo = Objects.requireNonNull(repo, "repo");
        this.validator = Objects.requireNonNull(validator, "validator");
    }

    @Override
    public BookResponse create(CreateBookParams params){
        Objects.requireNonNull(params, "params");

        Book created = Book.createNew(
            UUID.randomUUID(), 
            params.title(), 
            params.author(), 
            params.isbn(), 
            params.pubYear(), 
            params.genre(), 
            params.desc()
        );

        validator.validateBook(created);

        Book saved = repo.save(created);

        return new BookResponse(
            saved.id(), 
            saved.title(), 
            saved.author(), 
            saved.isbn(), 
            saved.pubYear(), 
            saved.genre(), 
            saved.desc()
        );
    }
}
