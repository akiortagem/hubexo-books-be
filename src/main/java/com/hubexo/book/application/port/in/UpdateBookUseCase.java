package com.hubexo.book.application.port.in;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.UpdateBookParams;

public interface UpdateBookUseCase {
    BookResponse updateBookById(String id, UpdateBookParams params);
}
