package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    //region Properties:
    private final CountryDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public CountryService(CountryDao dao){this.dao = dao;}
    //endregion

    //region Methods:
    public Country add(final Country country) {
        return dao.save(country);
    }

    public List<Country> getAll() { return dao.findAll(); }

    public Optional<Country> getById(Integer id) { return dao.findById(id); }

    public Country getByIso(String iso)
    {
        return dao.findByIso(iso);
    }
    //endregion
}
