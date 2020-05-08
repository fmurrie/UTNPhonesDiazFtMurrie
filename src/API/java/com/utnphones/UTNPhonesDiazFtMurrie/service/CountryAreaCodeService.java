package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CountryAreaCodeService {

    CountryAreaCodeDao countryAreaCodeDao;

    @Autowired
    public CountryAreaCodeService(CountryAreaCodeDao countryAreaCodeDao){this.countryAreaCodeDao=countryAreaCodeDao;}

    public List<CountryAreaCode> getCountryAreaCode(String code) {
        if (isNull(code)){
            return countryAreaCodeDao.findAll();
        }
        else { return countryAreaCodeDao.findByCode(code);}
    }

    public void add(final CountryAreaCode countryAreaCode) {
        countryAreaCodeDao.save(countryAreaCode);
    }
}
