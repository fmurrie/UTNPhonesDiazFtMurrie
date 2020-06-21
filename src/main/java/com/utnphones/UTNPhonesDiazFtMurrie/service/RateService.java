package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.RateDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateService
{
    //region Properties:
    private final RateDao dao;
    //endregion

    //region Constructors:
    @Autowired
    public RateService(RateDao dao) { this.dao = dao; }
    //endregion

    //region Methods:
    public List<Rate> getAll() { return dao.findAll(); }

    public Optional<Rate> getById(RateId id)
    {
        return dao.findById(id);
    }
    //endregion
}
