package com.hubexo.book.application.port.out;

import java.util.List;
import java.util.Optional;

import com.hubexo.book.domain.Book;

public interface BookRepositoryPort {
    Book save(Book book);
    Optional<Book> getById(String id);
    List<Book> listFirst(int limit);
    List<Book> listAfter(String cursorExclusive, int limit);
}
