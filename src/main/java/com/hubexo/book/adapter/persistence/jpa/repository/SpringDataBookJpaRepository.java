package com.hubexo.book.adapter.persistence.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hubexo.book.adapter.persistence.jpa.entity.BookJpaEntity;

public interface SpringDataBookJpaRepository extends JpaRepository<BookJpaEntity, String> {
    @Modifying
    @Query("delete from BookJpaEntity b where b.id = :id")
    int deleteByIdReturningCount(@Param("id") String id);

    Page<BookJpaEntity> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
        String titleKeyword,
        String authorKeyword,
        Pageable pageable
    );
}
