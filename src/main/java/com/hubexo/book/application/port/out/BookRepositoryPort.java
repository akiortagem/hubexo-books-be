package com.hubexo.book.application.port.out;

import java.util.Optional;

import com.hubexo.book.domain.Book;
import com.hubexo.book.application.dto.Paged;

public interface BookRepositoryPort {
    Book save(Book book);
    Book update(Book book);
    Optional<Book> getById(String id);
    Paged<Book> findPage(int pageIndexZeroBased, int pageSize);
    void deleteById(String id);
}
