package com.example.hello.book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

//JUnit4の場合必要、JUnit5では不要
//@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {
    @Test
    public void testBook1() {
        Book book = new Book("title1","author1");
        assertThat(book, isA(Book.class));
    }

    @Test
    public void testBook2() {
        Book book = new Book("title1","author1");
        assertThat(book.getTitle(), is("title1"));
        assertThat(book.getAuthor(), is("author1"));
    }

}
