package com.hubexo.book.application.port.in;

import com.hubexo.book.application.dto.BookResponse;

public interface GetBookUseCase {
    BookResponse getById(String id);
}
