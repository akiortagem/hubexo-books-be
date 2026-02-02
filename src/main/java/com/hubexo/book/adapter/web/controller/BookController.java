package com.hubexo.book.adapter.web.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubexo.book.adapter.web.mapper.BookRestMapper;
import com.hubexo.book.adapter.web.request.CreateBookRequest;
import com.hubexo.book.adapter.web.response.BookRestResponse;
import com.hubexo.book.application.port.in.CreateBookUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final CreateBookUseCase createBook;

    public BookController(CreateBookUseCase createBook){
        this.createBook = createBook;
    }

    @PostMapping
    public ResponseEntity<BookRestResponse> create(@Valid @RequestBody CreateBookRequest request){
        var result = createBook.create(BookRestMapper.toParams(request));
        var response = BookRestMapper.toResponse(result);

        return ResponseEntity.created(URI.create("/api/books/" + response.id())).body(response);
    }
}
