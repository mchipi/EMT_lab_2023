package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author save(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return this.authorRepository.save(author);
    }
    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }
}
