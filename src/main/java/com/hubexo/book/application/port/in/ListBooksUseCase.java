package com.hubexo.book.application.port.in;

import com.hubexo.book.adapter.web.response.BookPaginated;

public interface ListBooksUseCase {
    BookPaginated listBooks(String cursor, int limit);
}
