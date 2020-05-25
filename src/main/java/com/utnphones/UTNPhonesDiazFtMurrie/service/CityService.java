package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequestMapping("api/city/")
public class CityService {
    CityDao cityDao;

    @Autowired
    public CityService(CityDao cityDao){this.cityDao=cityDao;}

    @GetMapping("")
    public List<City> getCity(String name) {
        if (isNull(name)){
            return cityDao.findAll();
        }
        else { return cityDao.findByName(name);}
    }

    @PostMapping("")
    public void add(final City city) {
        cityDao.save(city);
    }
}
