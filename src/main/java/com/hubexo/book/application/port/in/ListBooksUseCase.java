package com.hubexo.book.application.port.in;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.PageResponse;

public interface ListBooksUseCase {
    PageResponse<BookResponse> listBooks(int page, int pageSize, String keyword);
}
