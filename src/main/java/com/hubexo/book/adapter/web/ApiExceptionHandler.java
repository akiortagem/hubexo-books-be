package com.hubexo.book.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hubexo.book.adapter.web.response.ApiErrorResponse;
import com.hubexo.book.domain.exceptions.BookNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> notFound(BookNotFoundException ex){
        return ResponseEntity.status(NOT_FOUND).body(new ApiErrorResponse("not_found", ex.getMessage()));
    }
}
