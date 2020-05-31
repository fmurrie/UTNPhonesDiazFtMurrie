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
    private final CityService service;

    //Constructors:
    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public void addCity(@RequestBody @Valid City city) {
        service.add(city);
    }

    @GetMapping("/")
    List<City> getAllCities() {
        return service.getAll();
    }

    @GetMapping("/{idCity}")
    ResponseEntity<Optional<City>> getCityById(@PathVariable Integer idCity) { return ResponseEntity.ok(service.getById(idCity)); }
}
