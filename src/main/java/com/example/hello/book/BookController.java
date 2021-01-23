package com.example.hello.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    protected BookService bookService;

    @PostMapping
    public Book add() {
        return bookService.addBook(new Book("TITLE", "AUTHOR"));
    }

    @GetMapping
    public List<Book> list() {
        return bookService.getBook();
    }

    @GetMapping("/{id}")
    public Book getBook(
        @PathVariable("id") String id) {
           return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
        @PathVariable("id") String id) {
            bookService.deleteBook(id);
            return new ResponseEntity<String>(
                "deleted book"+id, HttpStatus.OK);
    }
}
