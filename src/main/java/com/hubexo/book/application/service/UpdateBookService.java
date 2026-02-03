package com.hubexo.book.application.service;

import java.util.Objects;
import java.util.UUID;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.UpdateBookParams;
import com.hubexo.book.application.port.in.UpdateBookUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.domain.Book;

public class UpdateBookService implements UpdateBookUseCase{
    private final BookRepositoryPort repo;

    public UpdateBookService(BookRepositoryPort repo){
        this.repo = Objects.requireNonNull(repo, "repo");
    }

    @Override
    public BookResponse updateBookById(String id, UpdateBookParams params){
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(params, "params");

        UUID bookId = UUID.fromString(id);

        Book updated = Book.rehydrate(
            bookId,
            params.title(),
            params.author(),
            params.isbn(),
            params.pubYear(),
            params.genre(),
            params.desc()
        );

        Book saved = repo.update(updated);

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
