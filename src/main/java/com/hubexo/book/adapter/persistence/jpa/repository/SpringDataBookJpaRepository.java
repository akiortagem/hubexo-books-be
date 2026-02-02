package com.hubexo.book.adapter.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hubexo.book.adapter.persistence.jpa.entity.BookJpaEntity;

public interface SpringDataBookJpaRepository extends JpaRepository<BookJpaEntity, String> {
    
}
