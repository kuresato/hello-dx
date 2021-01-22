package com.example.hello.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book getBook(String id) {
        return new Book(id, "title"+id, "author"+id);
    }

    @Override
    public List<Book> getBook() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("1", "title1", "author1"));
        list.add(new Book("2", "title2", "author2"));
        return list;
    }

    @Override
    public void deleteBook(String id) {
        // nop
    }
    
}
