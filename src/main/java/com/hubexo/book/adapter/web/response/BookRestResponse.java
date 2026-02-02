package com.hubexo.book.adapter.web.response;

public record BookRestResponse(
    String id,
    String title,
    String author,
    String isbn,
    String pubYear,
    String genre,
    String desc
) {}
