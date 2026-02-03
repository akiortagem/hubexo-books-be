package com.hubexo.book.application.service;

import com.hubexo.book.application.port.in.DeleteBookUseCase;
import com.hubexo.book.application.port.out.BookRepositoryPort;

public class DeleteBookService implements DeleteBookUseCase{
    private final BookRepositoryPort repo;

    public DeleteBookService(BookRepositoryPort repo){
        this.repo = repo;
    }

    @Override
    public void deleteBookById(String id){
        repo.deleteById(id);
    }
}
