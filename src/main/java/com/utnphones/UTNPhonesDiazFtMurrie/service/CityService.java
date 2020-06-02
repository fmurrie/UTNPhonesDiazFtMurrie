package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    //Properties:
    private final CityDao dao;
    private final PhoneLineDao phDao;

    //Constructors:
    @Autowired
    public CityService(CityDao dao, PhoneLineDao phDao){
        this.dao = dao;
        this.phDao = phDao;
    }

    //Methods:
    public City add(final City city) {
        return dao.save(city);
    }

    public List<City> getAll()
    {
        return dao.findAll();
    }

    public Optional<City> getById(Integer id)
    {
        return dao.findById(id);
    }

    public List<PhoneLine> getByAreaCode221()
    {
        return phDao.getByAreaCode221();
    }
}
