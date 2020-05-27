package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CityService {
    CityDao cityDao;

    @Autowired
    public CityService(CityDao cityDao){this.cityDao=cityDao;}

    public List<City> getCity(String name) {
        if (isNull(name)){
            return cityDao.findAll();
        }
        else { return cityDao.findByName(name);}
    }

    public void add(final City city) {
        cityDao.save(city);
    }
}
