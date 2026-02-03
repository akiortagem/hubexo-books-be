package com.hubexo.book.adapter.web.mapper;

import com.hubexo.book.adapter.web.request.CreateBookRequest;
import com.hubexo.book.adapter.web.request.UpdateBookRequest;
import com.hubexo.book.adapter.web.response.BookRestResponse;
import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.CreateBookParams;
import com.hubexo.book.application.dto.UpdateBookParams;

public final class BookRestMapper {
    private BookRestMapper(){}

    public static CreateBookParams toParams(CreateBookRequest req){
        return new CreateBookParams(
            req.title(),
            req.author(),
            req.isbn(),
            req.pubYear(),
            req.genre(),
            req.desc()
        );
    }

    public static UpdateBookParams toParams(UpdateBookRequest req){
        return new UpdateBookParams(
            req.title(),
            req.author(),
            req.isbn(),
            req.pubYear(),
            req.genre(),
            req.desc());
    }

    public static BookRestResponse toResponse(BookResponse resp){
        return new BookRestResponse(
            resp.id().toString(),
            resp.title(),
            resp.author(),
            resp.isbn(),
            resp.pubYear(),
            resp.genre(),
            resp.desc()
        );
    }
}
