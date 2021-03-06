package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CityDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService
{
    //region Properties:
    private final CityDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public CityService(CityDao dao){this.dao = dao;}
    //endregion

    //region Methods:
    public List<City> getAll()
    {
        return dao.findAll();
    }

    public Optional<City> getById(Integer id)
    {
        return dao.findById(id);
    }
    //endregion
}
