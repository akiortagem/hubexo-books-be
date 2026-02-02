package com.hubexo.book.domain.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message){
        super(message);
    }
}
