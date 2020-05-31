package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
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
    List<City> getAllCities() {
        return cityService.getAll();
    }

    @GetMapping("/{idCity}")
    ResponseEntity<Optional<City>> getCityById(@PathVariable Integer idCity) { return ResponseEntity.ok(cityService.getById(idCity)); }
}
