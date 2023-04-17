package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.enums.Category;
import mk.ukim.finki.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }



}
