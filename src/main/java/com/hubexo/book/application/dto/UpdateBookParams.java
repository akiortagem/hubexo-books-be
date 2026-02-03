package com.hubexo.book.application.dto;

public record UpdateBookParams(
    String title,
    String author,
    String isbn,
    String pubYear,
    String genre,
    String desc
) {
    
}
