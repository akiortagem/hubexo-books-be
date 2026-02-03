package com.hubexo.book.application.service;

import java.util.List;

import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.PageResponse;
import com.hubexo.book.application.port.in.ListBooksUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;

public class ListBooksService implements ListBooksUseCase {
    private final BookRepositoryPort repo;

    public ListBooksService(BookRepositoryPort repo){
        this.repo = repo;
    }

    @Override
    public PageResponse<BookResponse> listBooks(int page, int pageSize){
        if(page < 1) throw new IllegalArgumentException("page must be >= 1");
        if(page < 1 || pageSize > 100) throw new IllegalArgumentException("can only have page between 1 and 100");

        int pageZero = page - 1;

        var paged = repo.findPage(pageZero, pageSize);
        
        List<BookResponse> items = paged.items()
            .stream()
            .map(b -> new BookResponse(
                b.id(), 
                b.title(), 
                b.author(), 
                b.isbn(), 
                b.pubYear(), 
                b.genre(), 
                b.genre())).toList();

        return new PageResponse<BookResponse>(
            page,
            pageSize,
            paged.totalPages(),
            paged.totalItems(),
            items
        );
    }
}
