package com.hubexo.book.domain.exceptions;

public class BookNotFoundException extends DomainException {
    public BookNotFoundException(String message){
        super(message);
    }
}
