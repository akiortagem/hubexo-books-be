package com.hubexo.book.application.service;

import java.util.Objects;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.domain.exceptions.BookNotFoundException;

public class GetBookService implements GetBookUseCase {
    private final BookRepositoryPort repo;

    public GetBookService(BookRepositoryPort repo){
        this.repo = Objects.requireNonNull(repo, "repo");
    }

    @Override
    public BookResponse getById(String id){
        var book = repo.getById(id).orElseThrow(() -> new BookNotFoundException("Book not found: " + id));

        return new BookResponse(
            book.id(), 
            book.title(), 
            book.author(), 
            book.isbn(), 
            book.pubYear(), 
            book.genre(), 
            book.desc()
        );
    }
}
