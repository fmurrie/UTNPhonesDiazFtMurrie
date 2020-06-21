package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController
{
    //region Properties:
    private final CityService service;
    //endregion

    //region Constructors:
    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }
    //endregion

    //region Methods:
    @GetMapping("/")
    ResponseEntity<List<City>> getAllCities() {
        List<City> cityList = service.getAll();
        if (cityList.size() > 0 )
            return ResponseEntity.ok(cityList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idCity}")
    ResponseEntity<Optional<City>> getCityById(@PathVariable Integer idCity) {
        Optional<City> city = service.getById(idCity);
        if (city != null)
            return ResponseEntity.ok(city);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //endregion
}
