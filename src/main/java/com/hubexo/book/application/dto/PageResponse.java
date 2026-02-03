package com.hubexo.book.application.dto;

import java.util.List;

public record PageResponse<T>(
    int page,
    int pageSize,
    int totalPages,
    long totalItems,
    List<T> items
) {
    
}
