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
    //Properties:
    private final RateDao dao;

    //Constructors:
    @Autowired
    public RateService(RateDao dao) { this.dao = dao; }

    //Methods:
    public void add(final Rate rate) { dao.save(rate); }

    public List<Rate> getAll() { return dao.findAll(); }

    public Optional<Rate> getById(RateId id)
    {
        return dao.findById(id);
    }
}
