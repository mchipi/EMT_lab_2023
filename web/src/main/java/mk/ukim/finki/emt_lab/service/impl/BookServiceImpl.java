package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.dto.BookDto;
import mk.ukim.finki.emt_lab.model.enums.Category;
import mk.ukim.finki.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt_lab.repository.BookRepository;
import mk.ukim.finki.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Book save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(InvalidParameterException::new);
        if (bookRepository.existsByName(bookDto.getName())) {
            this.bookRepository.deleteByName(bookDto.getName());
        }
        return this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies()));

    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(InvalidParameterException::new);
        book.setName(book.getName());
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(InvalidParameterException::new);
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return this.bookRepository.save(book);
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Book rentBookById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(InvalidParameterException::new);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return book;
    }

    @Override
    public Book save(String name, Category category, Author author, Integer availableCopies) {
        Book book = new Book(name, category, author, availableCopies);
        return this.bookRepository.save(book);
    }


}
