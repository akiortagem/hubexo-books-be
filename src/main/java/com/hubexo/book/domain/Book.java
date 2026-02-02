package com.hubexo.book.domain;

import java.util.UUID;

public final class Book {
    private final UUID id;
    private final String title;
    private final String author;
    private final String isbn;
    private final String pubYear;
    private final String genre;
    private final String desc;

    private Book(
        UUID id, 
        String title, 
        String author, 
        String isbn, 
        String pubYear, 
        String genre,
        String desc){
            this.id = id;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.pubYear = pubYear;
            this.genre = genre;
            this.desc = desc;
        }
    
    public static Book createNew(
        UUID id, 
        String title, 
        String author, 
        String isbn, 
        String pubYear, 
        String genre,
        String desc
    ){
        return new Book(id, title, author, isbn, pubYear, genre, desc);
    }

    public static Book rehydrate(
        UUID id, 
        String title, 
        String author, 
        String isbn, 
        String pubYear, 
        String genre,
        String desc
    ){
        return new Book(id, title, author, isbn, pubYear, genre, desc);
    }

    public UUID id() { return id; }
    public String title() { return title; }
    public String author() { return author; }
    public String isbn() { return isbn; }
    public String pubYear() { return pubYear; }
    public String genre() { return genre; }
    public String desc() { return desc; }
}
