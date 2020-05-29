package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    //Properties:
    CityDao cityDao;

    //Constructors:
    @Autowired
    public CityService(CityDao cityDao){this.cityDao=cityDao;}

    //Methods:
    public void add(final City city) {
        cityDao.save(city);
    }

    public List<City> getAll()
    {
        return cityDao.findAll();
    }

    public Optional<City> getById(Integer idCity)
    {
        return cityDao.findById(idCity);
    }
}
