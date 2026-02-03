package com.hubexo.book.adapter.persistence.jpa.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hubexo.book.adapter.persistence.jpa.entity.BookJpaEntity;

public interface SpringDataBookJpaRepository extends JpaRepository<BookJpaEntity, String> {
    List<BookJpaEntity> findByCreatedAtGreaterThanOrderByCreatedAtAscIdAsc(
        Instant createdAt, Pageable pageable
    );

    List<BookJpaEntity> findByCreatedAtGreaterThanOrCreatedAtEqualsAndIdGreaterThanOrderByCreatedAtAscIdAsc(
        Instant createdAt, Instant createdAt2, String id, Pageable pageable
    );
}
