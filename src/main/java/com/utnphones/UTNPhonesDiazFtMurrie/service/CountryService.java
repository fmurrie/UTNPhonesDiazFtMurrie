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
    private final CountryDao dao;

    //Constructors:
    @Autowired
    public CountryService(CountryDao dao){this.dao = dao;}

    //Methods:
    public void add(final Country country) {
        dao.save(country);
    }

    public List<Country> getAll() { return dao.findAll(); }

    public Optional<Country> getById(Integer id) { return dao.findById(id); }

    public Country getByIso(String iso)
    {
        return dao.findByIso(iso);
    }
}
