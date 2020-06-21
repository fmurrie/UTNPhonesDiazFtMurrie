package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController
{
    //region Properties:
    private final CountryService service;
    //endregion

    //region Constructors:
    @Autowired
    public CountryController(CountryService service) { this.service = service; }
    //endregion

    //region Methods:
    public List<Country> getAllCountries() { return service.getAll(); }

    public Optional<Country> getCountryById(Integer idCountry) { return service.getById(idCountry); }
    //endregion
}
