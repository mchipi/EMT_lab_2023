package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.repository.AuthorRepository;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author save(String name, String surname, Country country);
    Author save(Author author);
}
