package com.hubexo.book.adapter.persistence.jpa;

import java.util.Optional;

import com.hubexo.book.adapter.persistence.jpa.entity.BookJpaEntity;
import com.hubexo.book.adapter.persistence.jpa.mapper.BookJpaMapper;
import com.hubexo.book.adapter.persistence.jpa.repository.SpringDataBookJpaRepository;
import com.hubexo.book.application.port.out.BookRepositoryPort;
import com.hubexo.book.domain.Book;

import jakarta.transaction.Transactional;

public class BookRepositoryJpaAdapter implements BookRepositoryPort {
    private final SpringDataBookJpaRepository repo;

    public BookRepositoryJpaAdapter(SpringDataBookJpaRepository repo){
        this.repo = repo;
    }

    @Override
    @Transactional
    public Book save(Book book){
        BookJpaEntity saved = repo.save(BookJpaMapper.toEntity(book));
        return BookJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Book> getById(String id){
        return repo.findById(id).map(BookJpaMapper::toDomain);
    }
}
