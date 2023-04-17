package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.dto.BookDto;
import mk.ukim.finki.emt_lab.model.enums.Category;
import mk.ukim.finki.emt_lab.service.impl.BookServiceImpl;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(BookDto bookDto);
    Book save(String name,Category category, Author author, Integer availableCopies);
    Book edit(Long id,BookDto bookDto);
    void deleteById(Long id);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book rentBookById(Long id);
}
