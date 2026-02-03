package com.hubexo.book.adapter.web.response;

import java.util.List;

import com.hubexo.book.application.dto.BookResponse;

public record BookPaginated(List<BookResponse> items, String next) {}
