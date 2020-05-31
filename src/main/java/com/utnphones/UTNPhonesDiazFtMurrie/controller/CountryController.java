package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController
{
    //Properties:
    private final CountryService service;

    //Constructors:
    @Autowired
    public CountryController(CountryService service) { this.service = service; }

    //Methods:
    @PostMapping("/")
    public void addCountry(@RequestBody @Valid Country country) {
        service.add(country);
    }

    @GetMapping("/")
    List<Country> getAllCountries() { return service.getAll(); }

    @GetMapping("/{idCountry}")
    ResponseEntity<Optional<Country>> getCountryById(@PathVariable Integer idCountry) { return ResponseEntity.ok(service.getById(idCountry)); }
}
