package fr.nadeva.spring.springdata;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
public class BookRepositoryTest {


    @Autowired
    BookRepository bookRepository;

    @Test
    public void repository() {
        Book book = new Book("Passionate Programmer", "Chad Fowler");
        bookRepository.save(book);

        List<Book> anotherBook = bookRepository.findByName("Passionate Programmer");

        assertThat(anotherBook).isNotEmpty().hasSize(1);

        List<Book> myAuthoBook=bookRepository.findByAuthor("Chad Fowler");
        assertThat(myAuthoBook).isNotEmpty().hasSize(1);
        assertThat(bookRepository.findByNameOrAuthor("XXX","Chad Fowler")).isNotEmpty().hasSize(1);

    }

}
