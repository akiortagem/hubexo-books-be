package com.hubexo.book.application.dto;

import java.util.List;

public record Paged<T> (
    List<T> items,
    long totalItems,
    int totalPages
){
   
}
