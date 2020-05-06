package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CountryAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.CountryAreaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryAreaCodeService {

    CountryAreaCodeDao countryAreaCodeDao;

    @Autowired
    public CountryAreaCodeService(CountryAreaCodeDao countryAreaCodeDao){this.countryAreaCodeDao=countryAreaCodeDao;}

    public List<CountryAreaCode> getCountryAreaCodes() {
        return countryAreaCodeDao.findAll();
    }

    public void add(final CountryAreaCode countryAreaCode) {
        countryAreaCodeDao.save(countryAreaCode);
    }
}
