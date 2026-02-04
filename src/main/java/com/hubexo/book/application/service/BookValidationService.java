package com.hubexo.book.application.service;

import java.util.Objects;

import com.hubexo.book.application.port.in.BookValidationUseCase;
import com.hubexo.book.domain.Book;

public class BookValidationService implements BookValidationUseCase {
    @Override
    public void validateBook(Book book){
        Objects.requireNonNull(book, "book");
        String isbn = book.isbn();
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("isbn is required");
        }

        String normalized = normalizeIsbn(isbn);
        if(!isValidIsbn10(normalized) && !isValidIsbn13(normalized)){
            throw new IllegalArgumentException("isbn is invalid");
        }
    }

    private static String normalizeIsbn(String isbn){
        return isbn.replace("-", "").replace(" ", "").toUpperCase();
    }

    private static boolean isValidIsbn10(String isbn){
        if(isbn.length() != 10){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            char ch = isbn.charAt(i);
            int digit;
            if(i == 9 && (ch == 'X')){
                digit = 10;
            } else if(Character.isDigit(ch)){
                digit = ch - '0';
            } else {
                return false;
            }
            int weight = 10 - i;
            sum += weight * digit;
        }

        return sum % 11 == 0;
    }

    private static boolean isValidIsbn13(String isbn){
        if(isbn.length() != 13){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < 13; i++){
            char ch = isbn.charAt(i);
            if(!Character.isDigit(ch)){
                return false;
            }
            int digit = ch - '0';
            if(i < 12){
                int weight = (i % 2 == 0) ? 1 : 3;
                sum += weight * digit;
            } else {
                int check = (10 - (sum % 10)) % 10;
                return digit == check;
            }
        }

        return false;
    }
}
