package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import com.utnphones.UTNPhonesDiazFtMurrie.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rate")
public class RateController
{
    //Properties:
    private final RateService service;

    //Constructors:
    @Autowired
    public RateController(RateService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public void addRate(@RequestBody @Valid Rate rate) {
        service.add(rate);
    }

    @GetMapping("/")
    List<Rate> getAllRates() {
        return service.getAll();
    }

    @GetMapping("/{idOriginCity}-{idDestinyCity}")
    ResponseEntity<Optional<Rate>> getRateById(@PathVariable Integer idOriginCity,@PathVariable Integer idDestinyCity) {
        return ResponseEntity.ok(service.getById(new RateId(idOriginCity,idDestinyCity)));
    }
}
