package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneLineService {

    //Properties:
    private final PhoneLineDao dao;

    //Constructors:
    @Autowired
    public PhoneLineService (PhoneLineDao dao) {
        this.dao = dao;
    }

    public PhoneLine addPhoneLine(PhoneLine phoneLine) throws LineAlreadyExistsException { return dao.save(phoneLine); }

    //Methods:
    public List<PhoneLine> getAll()
    {
        return dao.findAll();
    }

    public Optional<PhoneLine> getPhoneLineById(Integer id)
    {
        return dao.findById(id);
    }

}
