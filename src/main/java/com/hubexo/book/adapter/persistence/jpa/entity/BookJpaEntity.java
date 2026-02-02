package com.hubexo.book.adapter.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(
    name = "books",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_books_isbn", columnNames = "isbn")
    }
)
public class BookJpaEntity {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "pub_year", nullable = false, length = 4)
    private String pubYear;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "description", nullable = false, length = 2000)
    private String desc;

    protected BookJpaEntity() {
    }

    public BookJpaEntity(
        String id,
        String title,
        String author,
        String isbn,
        String pubYear,
        String genre,
        String desc
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pubYear = pubYear;
        this.genre = genre;
        this.desc = desc;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getPubYear() { return pubYear; }
    public String getGenre() { return genre; }
    public String getDesc() { return desc; }
}
