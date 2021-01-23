package com.example.hello.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repos;

    @Override
    public Book addBook(Book book) {
        return repos.save(book);
    }

    @Override
    public Book getBook(String id) {
        return repos.findById(id).get();
    }

    @Override
    public List<Book> getBook() {
        return repos.findAll();
    }

    @Override
    public void deleteBook(String id) {
        repos.deleteById(id);
    }

}
