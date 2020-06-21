package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
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
    public List<City> getAllCities() { return service.getAll(); }

    public Optional<City> getCityById(Integer idCity)
    {
        return service.getById(idCity);
    }
    //endregion
}
