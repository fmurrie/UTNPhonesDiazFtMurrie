package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.InterAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterAreaCodeService {

    InterAreaCodeDao interAreaCodeDao;

    @Autowired
    public InterAreaCodeService(InterAreaCodeDao interAreaCodeDao){this.interAreaCodeDao=interAreaCodeDao;}

    public List<InterAreaCode> getInterAreaCodes() {
        return interAreaCodeDao.findAll();
    }

    public void add(final InterAreaCode interAreaCode) {
        interAreaCodeDao.save(interAreaCode);
    }
}
