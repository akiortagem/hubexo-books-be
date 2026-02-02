package com.hubexo.book.adapter.web.request;

import jakarta.validation.constraints.NotBlank;

public record CreateBookRequest(
    @NotBlank String title,
    @NotBlank String author,
    @NotBlank String isbn,
    @NotBlank String pubYear,
    @NotBlank String genre,
    @NotBlank String desc
) {}
