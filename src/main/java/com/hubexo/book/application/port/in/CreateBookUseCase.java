package com.hubexo.book.application.port.in;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.CreateBookParams;

public interface CreateBookUseCase {
    BookResponse create(CreateBookParams params);
}
