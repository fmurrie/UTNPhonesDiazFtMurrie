package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("countryAreaCode/")
public class CountryAreaCodeController {

    private final CountryAreaCodeService countryAreaCodeService;

    @Autowired
    public CountryAreaCodeController(CountryAreaCodeService countryAreaCodeService) {
        this.countryAreaCodeService = countryAreaCodeService;
    }

    @PostMapping("/")
    public void addCountryAreaCode(@RequestBody @Valid CountryAreaCode countryAreaCode) {
        countryAreaCodeService.add(countryAreaCode);
    }

    @GetMapping("/")
    List<CountryAreaCode> getCountryAreaCode(@RequestParam (required = false) String code) {
        return countryAreaCodeService.getCountryAreaCode(code);
    }

}
