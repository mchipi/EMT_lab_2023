package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Country;

public interface CountryService {
    Country save(String name, String continent);
    Country save(Country country);
}
