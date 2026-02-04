package com.hubexo.book.adapter.web.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubexo.book.adapter.web.mapper.BookRestMapper;
import com.hubexo.book.adapter.web.request.CreateBookRequest;
import com.hubexo.book.adapter.web.request.UpdateBookRequest;
import com.hubexo.book.adapter.web.response.BookRestResponse;
import com.hubexo.book.application.dto.PageResponse;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.in.DeleteBookUseCase;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.in.ListBooksUseCase;
import com.hubexo.book.application.port.in.UpdateBookUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final CreateBookUseCase bookCreator;
    private final GetBookUseCase bookGetter;
    private final ListBooksUseCase bookLister;
    private final DeleteBookUseCase bookDeleter;
    private final UpdateBookUseCase bookUpdater;

    public BooksController(
        CreateBookUseCase bookCreator, 
        GetBookUseCase bookGetter, 
        ListBooksUseCase bookLister, 
        DeleteBookUseCase bookDeleter,
        UpdateBookUseCase bookUpdater
    ){
        this.bookCreator = bookCreator;
        this.bookGetter = bookGetter;
        this.bookLister = bookLister;
        this.bookDeleter = bookDeleter;
        this.bookUpdater = bookUpdater;
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
        @RequestParam(defaultValue = "20") int pageSize,
        @RequestParam(required = false, defaultValue = "") String keywordString
    ){
        var result = bookLister.listBooks(page, pageSize, keywordString);

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

    @PutMapping("/{id}")
    public ResponseEntity<BookRestResponse> updateBookById(@PathVariable String id, @Valid @RequestBody UpdateBookRequest req){
        var book = bookUpdater.updateBookById(id, BookRestMapper.toParams(req));
        return ResponseEntity.ok().body(BookRestMapper.toResponse(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        bookDeleter.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
