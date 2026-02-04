package com.hubexo.book.adapter.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubexo.book.adapter.web.request.CreateBookRequest;
import com.hubexo.book.adapter.web.request.UpdateBookRequest;
import com.hubexo.book.application.dto.BookResponse;
import com.hubexo.book.application.dto.CreateBookParams;
import com.hubexo.book.application.dto.PageResponse;
import com.hubexo.book.application.dto.UpdateBookParams;
import com.hubexo.book.application.port.in.CreateBookUseCase;
import com.hubexo.book.application.port.in.DeleteBookUseCase;
import com.hubexo.book.application.port.in.GetBookUseCase;
import com.hubexo.book.application.port.in.ListBooksUseCase;
import com.hubexo.book.application.port.in.UpdateBookUseCase;

@WebMvcTest(BooksController.class)
class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private CreateBookUseCase bookCreator;

    @MockitoBean
    private GetBookUseCase bookGetter;

    @MockitoBean
    private ListBooksUseCase bookLister;

    @MockitoBean
    private DeleteBookUseCase bookDeleter;

    @MockitoBean
    private UpdateBookUseCase bookUpdater;

    @Test
    void create_returns201AndBody() throws Exception {
        var id = UUID.fromString("1f9b2f8e-0b52-4fd0-9c2c-1a4c7e36b3df");
        var response = new BookResponse(
            id,
            "Clean Architecture",
            "Robert C. Martin",
            "9780134494166",
            "2017",
            "Software",
            "A guide to software structure"
        );
        when(bookCreator.create(any(CreateBookParams.class))).thenReturn(response);

        var request = new CreateBookRequest(
            "Clean Architecture",
            "Robert C. Martin",
            "9780134494166",
            "2017",
            "Software",
            "A guide to software structure"
        );

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(header().string("Location", "/api/books/" + id))
            .andExpect(jsonPath("$.id").value(id.toString()))
            .andExpect(jsonPath("$.title").value("Clean Architecture"))
            .andExpect(jsonPath("$.author").value("Robert C. Martin"))
            .andExpect(jsonPath("$.isbn").value("9780134494166"))
            .andExpect(jsonPath("$.pubYear").value("2017"))
            .andExpect(jsonPath("$.genre").value("Software"))
            .andExpect(jsonPath("$.desc").value("A guide to software structure"));

        var captor = ArgumentCaptor.forClass(CreateBookParams.class);
        verify(bookCreator).create(captor.capture());
        var params = captor.getValue();
        org.junit.jupiter.api.Assertions.assertEquals("Clean Architecture", params.title());
        org.junit.jupiter.api.Assertions.assertEquals("Robert C. Martin", params.author());
        org.junit.jupiter.api.Assertions.assertEquals("9780134494166", params.isbn());
        org.junit.jupiter.api.Assertions.assertEquals("2017", params.pubYear());
        org.junit.jupiter.api.Assertions.assertEquals("Software", params.genre());
        org.junit.jupiter.api.Assertions.assertEquals("A guide to software structure", params.desc());
    }

    @Test
    void create_withInvalidIsbn_returns400() throws Exception {
        when(bookCreator.create(any(CreateBookParams.class)))
            .thenThrow(new IllegalArgumentException("isbn is invalid"));

        var request = new CreateBookRequest(
            "Clean Architecture",
            "Robert C. Martin",
            "123",
            "2017",
            "Software",
            "A guide to software structure"
        );

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("bad_request"))
            .andExpect(jsonPath("$.message").value("isbn is invalid"));

        verify(bookCreator).create(any(CreateBookParams.class));
    }

    @Test
    void listBooks_returnsPagedResponse() throws Exception {
        var id = UUID.fromString("4f6f8e9a-2f5c-4b1b-bb6a-9b3d1cc8d7ad");
        var book = new BookResponse(
            id,
            "The Pragmatic Programmer",
            "Andrew Hunt",
            "9780201616224",
            "1999",
            "Software",
            "Classic software craftsmanship"
        );
        var pageResponse = new PageResponse<>(
            1,
            20,
            1,
            1L,
            List.of(book)
        );
        when(bookLister.listBooks(1, 20)).thenReturn(pageResponse);

        mockMvc.perform(get("/api/books")
                .param("page", "1")
                .param("pageSize", "20"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.page").value(1))
            .andExpect(jsonPath("$.pageSize").value(20))
            .andExpect(jsonPath("$.totalPages").value(1))
            .andExpect(jsonPath("$.totalItems").value(1))
            .andExpect(jsonPath("$.items[0].id").value(id.toString()))
            .andExpect(jsonPath("$.items[0].title").value("The Pragmatic Programmer"))
            .andExpect(jsonPath("$.items[0].author").value("Andrew Hunt"))
            .andExpect(jsonPath("$.items[0].isbn").value("9780201616224"))
            .andExpect(jsonPath("$.items[0].pubYear").value("1999"))
            .andExpect(jsonPath("$.items[0].genre").value("Software"))
            .andExpect(jsonPath("$.items[0].desc").value("Classic software craftsmanship"));
    }

    @Test
    void getById_returnsBook() throws Exception {
        var id = UUID.fromString("7a38a1f0-0e5d-4a80-8212-d7a0c3a4b12d");
        var response = new BookResponse(
            id,
            "Domain-Driven Design",
            "Eric Evans",
            "9780321125217",
            "2003",
            "Software",
            "Strategic design and modeling"
        );
        when(bookGetter.getById(id.toString())).thenReturn(response);

        mockMvc.perform(get("/api/books/{id}", id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id.toString()))
            .andExpect(jsonPath("$.title").value("Domain-Driven Design"))
            .andExpect(jsonPath("$.author").value("Eric Evans"))
            .andExpect(jsonPath("$.isbn").value("9780321125217"))
            .andExpect(jsonPath("$.pubYear").value("2003"))
            .andExpect(jsonPath("$.genre").value("Software"))
            .andExpect(jsonPath("$.desc").value("Strategic design and modeling"));
    }

    @Test
    void updateBookById_returnsUpdatedBook() throws Exception {
        var id = UUID.fromString("f8c9a1b2-1a35-4b61-9de6-0d9c96e8b1be");
        var response = new BookResponse(
            id,
            "Refactoring",
            "Martin Fowler",
            "9780201485677",
            "1999",
            "Software",
            "Improving the design of existing code"
        );
        when(bookUpdater.updateBookById(eq(id.toString()), any(UpdateBookParams.class))).thenReturn(response);

        var request = new UpdateBookRequest(
            "Refactoring",
            "Martin Fowler",
            "9780201485677",
            "1999",
            "Software",
            "Improving the design of existing code"
        );

        mockMvc.perform(put("/api/books/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id.toString()))
            .andExpect(jsonPath("$.title").value("Refactoring"))
            .andExpect(jsonPath("$.author").value("Martin Fowler"))
            .andExpect(jsonPath("$.isbn").value("9780201485677"))
            .andExpect(jsonPath("$.pubYear").value("1999"))
            .andExpect(jsonPath("$.genre").value("Software"))
            .andExpect(jsonPath("$.desc").value("Improving the design of existing code"));

        var captor = ArgumentCaptor.forClass(UpdateBookParams.class);
        verify(bookUpdater).updateBookById(eq(id.toString()), captor.capture());
        var params = captor.getValue();
        org.junit.jupiter.api.Assertions.assertEquals("Refactoring", params.title());
        org.junit.jupiter.api.Assertions.assertEquals("Martin Fowler", params.author());
        org.junit.jupiter.api.Assertions.assertEquals("9780201485677", params.isbn());
        org.junit.jupiter.api.Assertions.assertEquals("1999", params.pubYear());
        org.junit.jupiter.api.Assertions.assertEquals("Software", params.genre());
        org.junit.jupiter.api.Assertions.assertEquals("Improving the design of existing code", params.desc());
    }

    @Test
    void delete_returns204() throws Exception {
        var id = UUID.fromString("1d1f9f24-2e54-4a3f-8f8e-2f5f05e8f3ef");
        doNothing().when(bookDeleter).deleteBookById(id.toString());

        mockMvc.perform(delete("/api/books/{id}", id))
            .andExpect(status().isNoContent());

        verify(bookDeleter).deleteBookById(id.toString());
    }
}
