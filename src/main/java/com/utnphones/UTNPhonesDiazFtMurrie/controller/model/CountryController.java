package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
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
    @PostMapping("/")
    public ResponseEntity<Country> addCountry(@RequestBody @Valid Country country) {
        return ResponseEntity.ok(service.add(country));
    }

    @GetMapping("/")
    ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countryList = service.getAll();
        if(countryList.size() > 0 )
            return ResponseEntity.ok(countryList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idCountry}")
    ResponseEntity<Optional<Country>> getCountryById(@PathVariable Integer idCountry) {
        Optional<Country> country = service.getById(idCountry);
        if(country != null)
            return ResponseEntity.ok(country);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //endregion
}
