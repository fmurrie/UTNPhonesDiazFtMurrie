package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CountryService {
    CountryDao countryDao;

    @Autowired
    public CountryService(CountryDao countryDao){this.countryDao=countryDao;}

    public List<Country> getCountry(String name) {
        if (isNull(name)){
            return countryDao.findAll();
        }
        else { return countryDao.findByName(name);}
    }

    public void add(final Country country) {
        countryDao.save(country);
    }
}
