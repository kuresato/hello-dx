package com.example.hello.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@SpringBootTest
//@AutoConfigureDataMongo
//@DataMongoTest
public class BookRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BookRepository repository;

    @BeforeEach
    public void beforeEach() {
        DBObject toSave = BasicDBObjectBuilder.start()
            .add("title", "title1")
            .add("author", "author1")
            .get();
        mongoTemplate.dropCollection("books");
        mongoTemplate.save(toSave, "books");
    }

    @Test
    public void testFindAll() {
        List<Book> books = repository.findAll();
        assertThat(books.get(0).getTitle()).isEqualTo("title1");
    }

}
