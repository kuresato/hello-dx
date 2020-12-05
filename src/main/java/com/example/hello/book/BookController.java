package com.example.hello.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping
    public List<Book> list() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("1", "title1", "author1"));
        list.add(new Book("2", "title2", "author2"));
        return list;
    }

    @GetMapping("/{id}")
    public Book getBook(
        @PathVariable("id") String id) {
            return new Book(id, "title"+id, "author"+id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
        @PathVariable("id") String id) {
            return new ResponseEntity<String>(
                "deleted book"+id, HttpStatus.OK);
    }
}
