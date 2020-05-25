package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.InterAreaCodeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class InterAreaCodeService {

    InterAreaCodeDao interAreaCodeDao;

    @Autowired
    public InterAreaCodeService(InterAreaCodeDao interAreaCodeDao){this.interAreaCodeDao=interAreaCodeDao;}

    public List<InterAreaCode> getInterAreaCode(String code) {
        if (isNull(code)){
            return interAreaCodeDao.findAll();
        }
        else { return interAreaCodeDao.findByCode(code);}
    }

    public void add(final InterAreaCode interAreaCode) {
        interAreaCodeDao.save(interAreaCode);
    }
}
