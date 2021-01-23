package com.example.hello.book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book getBook(String id);
    List<Book> getBook();
    void deleteBook(String id);
}
