package com.hubexo.book.application.dto;

import java.util.UUID;

public record BookResponse(
    UUID id,
    String title,
    String author,
    String isbn,
    String pubYear,
    String genre,
    String desc
) {}
