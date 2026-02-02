package com.hubexo.book.application.port.out;

import com.hubexo.book.domain.Book;

public interface BookRepositoryPort {
    Book save(Book book);
}
