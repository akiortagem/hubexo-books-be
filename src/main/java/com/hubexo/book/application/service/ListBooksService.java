package com.hubexo.book.application.service;

import java.util.List;

import com.hubexo.book.adapter.web.response.BookPaginated;
import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.port.in.ListBooksUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.domain.Book;

public class ListBooksService implements ListBooksUseCase {
    private final BookRepositoryPort repo;

    public ListBooksService(BookRepositoryPort repo){
        this.repo = repo;
    }

    private static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(max, v));
    }

    @Override
    public BookPaginated listBooks(String cursor, int limit){
        int safeLim = clamp(limit, 1, 100);

        List<Book> books = (cursor == null || cursor.isBlank()) 
            ? repo.listFirst(safeLim) 
            : repo.listAfter(cursor, safeLim);
        
        List<BookResponse> items = books
            .stream()
            .map(b -> new BookResponse(
                b.id(), 
                b.title(), 
                b.author(), 
                b.isbn(), 
                b.pubYear(), 
                b.genre(), 
                b.genre())).toList();
        String nextCursor = (items.size() == safeLim) ? items.get(items.size() - 1).id().toString() : null;

        return new BookPaginated(items, nextCursor);
    }
}
