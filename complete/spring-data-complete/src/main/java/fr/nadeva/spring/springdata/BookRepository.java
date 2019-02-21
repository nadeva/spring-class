package fr.nadeva.spring.springdata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByNameAndAuthor(String name, String author);
    List<Book> findByNameOrAuthor(String name, String author);
}
