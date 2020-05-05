package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("country/")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/")
    public void addCountry(@RequestBody @Valid Country country) {
        countryService.add(country);
    }

    @GetMapping("/")
    List<Country> getCountries() {
        return countryService.getCountries();
    }
}
