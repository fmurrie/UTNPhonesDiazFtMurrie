package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("city/")
public class CityController
{
    //Properties:
    private final CityService cityService;

    //Constructors:
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //Methods:
    @PostMapping("/")
    public void addCity(@RequestBody @Valid City city) {
        cityService.add(city);
    }

    @GetMapping("/")
    List<City> getCity(String name) {
        return cityService.getCity(name);
    }
}
