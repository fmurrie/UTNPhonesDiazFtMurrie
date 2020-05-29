package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    //Properties:
    CountryDao countryDao;

    //Constructors:
    @Autowired
    public CountryService(CountryDao countryDao){this.countryDao=countryDao;}

    //Methods:
    public void add(final Country country) {
        countryDao.save(country);
    }

    public List<Country> getAll() { return countryDao.findAll(); }

    public Optional<Country> getById(Integer id) { return countryDao.findById(id); }
}
