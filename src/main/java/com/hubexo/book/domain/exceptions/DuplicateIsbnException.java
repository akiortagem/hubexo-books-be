package com.hubexo.book.domain.exceptions;

public class DuplicateIsbnException extends DomainException {
    public DuplicateIsbnException(String message){
        super(message);
    }
}
