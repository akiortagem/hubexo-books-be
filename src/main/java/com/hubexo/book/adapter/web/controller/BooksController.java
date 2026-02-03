package com.hubexo.book.adapter.web.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubexo.book.adapter.web.mapper.BookRestMapper;
import com.hubexo.book.adapter.web.request.CreateBookRequest;
import com.hubexo.book.adapter.web.response.BookRestResponse;
import com.hubexo.book.application.dto.PageResponse;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.in.ListBooksUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final CreateBookUseCase bookCreator;
    private final GetBookUseCase bookGetter;
    private final ListBooksUseCase bookLister;

    public BooksController(CreateBookUseCase bookCreator, GetBookUseCase bookGetter, ListBooksUseCase bookLister){
        this.bookCreator = bookCreator;
        this.bookGetter = bookGetter;
        this.bookLister = bookLister;
    }

    @PostMapping
    public ResponseEntity<BookRestResponse> create(@Valid @RequestBody CreateBookRequest request){
        var result = bookCreator.create(BookRestMapper.toParams(request));
        var response = BookRestMapper.toResponse(result);

        return ResponseEntity.created(URI.create("/api/books/" + response.id())).body(response);
    }

    @GetMapping
    public PageResponse<BookRestResponse> listBooks(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "20") int pageSize
    ){
        var result = bookLister.listBooks(page, pageSize);

        return new PageResponse<BookRestResponse>(
            result.page(),
            result.pageSize(),
            result.totalPages(),
            result.totalItems(),
            result.items()
                .stream()
                .map(b -> new BookRestResponse(
                    b.id().toString(), 
                    b.title(),
                     b.author(), 
                     b.isbn(), 
                     b.pubYear(), 
                     b.genre(), 
                     b.desc()
                    )).toList()
        );
    }

    @GetMapping("/{id}")
    public BookRestResponse getById(@PathVariable String id){
        var res = bookGetter.getById(id);
        return BookRestMapper.toResponse(res);
    }
}
