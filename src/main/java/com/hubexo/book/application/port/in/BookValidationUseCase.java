package com.hubexo.book.application.port.in;

import com.hubexo.book.domain.Book;

public interface BookValidationUseCase {
    void validateBook(Book book);
}
