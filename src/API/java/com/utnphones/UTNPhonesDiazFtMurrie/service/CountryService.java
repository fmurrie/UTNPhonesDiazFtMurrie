package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    CountryDao countryDao;

    @Autowired
    public CountryService(CountryDao countryDao){this.countryDao=countryDao;}

    public List<Country> getCountries() {
        return countryDao.findAll();
    }

    public void add(final Country country) {
        countryDao.save(country);
    }
}
