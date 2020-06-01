package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import com.utnphones.UTNPhonesDiazFtMurrie.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity <Rate> addRate(@RequestBody @Valid Rate rate) {
        return ResponseEntity.ok(service.add(rate));
    }

    @GetMapping("/")
    ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rateList = service.getAll();
        if(rateList.size() > 0)
             return ResponseEntity.ok(rateList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/{idOriginCity}-{idDestinyCity}")
    ResponseEntity<Optional<Rate>> getRateById(@PathVariable Integer idOriginCity,@PathVariable Integer idDestinyCity) {
        Optional<Rate> rate = service.getById(new RateId(idOriginCity,idDestinyCity));
        if(rate != null)
            return ResponseEntity.ok(rate);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
