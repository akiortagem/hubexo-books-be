package com.hubexo.book.adapter.persistence.jpa.mapper;

import java.util.Objects;
import java.util.UUID;

import com.hubexo.book.adapter.persistence.jpa.entity.BookJpaEntity;
import com.hubexo.book.domain.Book;

public final class BookJpaMapper {
    private BookJpaMapper(){}

    public static BookJpaEntity toEntity(Book book){
        Objects.requireNonNull(book, "book");

        return new BookJpaEntity(
            book.id().toString(),
            book.title(),
            book.author(),
            book.isbn(),
            book.pubYear(),
            book.genre(),
            book.desc(),
            null
        );
    }

    public static Book toDomain(BookJpaEntity entity){
        Objects.requireNonNull(entity, "entity");

        return Book.rehydrate(
            UUID.fromString(entity.getId()),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getIsbn(),
            entity.getPubYear(),
            entity.getGenre(),
            entity.getDesc()
        );
    }
}
