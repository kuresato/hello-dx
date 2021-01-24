package com.example.hello.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

// @SpringBootTest
// @AutoConfigureMockMvc
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testBook() {
        Book book = new Book("title1","author1");
        assertThat(book).isInstanceOf(Book.class);
        assertThat(book.getTitle()).isEqualTo("title1");
        assertThat(book.getAuthor()).isEqualTo("author1");
    }

    @Test
    public void testGetBook() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("タイトル１", "著者１"));

        when(bookService.getBook()).thenReturn(books);

        mvc.perform(get("/book"))
            .andExpect(status().isOk())
            .andExpect(content().json("[{\"title\":\"タイトル１\"}]"));
    }
}
