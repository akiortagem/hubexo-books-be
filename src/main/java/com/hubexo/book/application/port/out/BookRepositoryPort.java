package com.hubexo.book.application.port.out;

import java.util.Optional;

import com.hubexo.book.domain.Book;

public interface BookRepositoryPort {
    Book save(Book book);
    Optional<Book> getById(String id);
}
