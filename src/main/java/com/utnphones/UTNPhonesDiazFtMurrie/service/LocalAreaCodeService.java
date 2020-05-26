package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.LocalAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import com.utnphones.UTNPhonesDiazFtMurrie.model.LocalAreaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class LocalAreaCodeService {

    LocalAreaCodeDao localAreaCodeDao;

    @Autowired
    public LocalAreaCodeService(LocalAreaCodeDao localAreaCodeDao){this.localAreaCodeDao=localAreaCodeDao;}

    public List<LocalAreaCode> getLocalAreaCode(String code) {
        if (isNull(code)){
            return localAreaCodeDao.findAll();
        }
        else { return localAreaCodeDao.findByCode(code);}
    }

    public void add(final LocalAreaCode localAreaCode) {
        localAreaCodeDao.save(localAreaCode);
    }


}
