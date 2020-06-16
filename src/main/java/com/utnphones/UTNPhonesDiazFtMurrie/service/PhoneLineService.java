package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneLineService {

    //Properties:
    private final PhoneLineDao phoneLineDao;
    private final UserDao userDao;

    //Constructors:
    @Autowired
    public PhoneLineService(PhoneLineDao phoneLineDao, UserDao userDao) {
        this.phoneLineDao = phoneLineDao;
        this.userDao = userDao;
    }

    public PhoneLine addPhoneLine(PhoneLine phoneLine) throws LineAlreadyExistsException { return phoneLineDao.save(phoneLine); }

    //Methods:
    public List<PhoneLine> getAll()
    {
        return phoneLineDao.findAll();
    }

    public Optional<PhoneLine> getPhoneLineById(Integer id)
    {
        return phoneLineDao.findById(id);
    }

    public List<LineAndCallsQuantityDto> top10Destinataries(Integer userId) throws UserNotexistException {
        List<LineAndCallsQuantityDto> list = new ArrayList<>();
        if (userDao.existsById(userId)){
            for (PhoneLine phoneLine : phoneLineDao.top10Destinataries(userId)){
                LineAndCallsQuantityDto dto = new LineAndCallsQuantityDto();
                dto.setFavoritePhoneLine(phoneLine);
                dto.setCallsQuantity(phoneLineDao.callsQuantity(userId,phoneLine.getIdPhoneLine()));
                list.add(dto);
            }
            return list;
        }
        else
            throw new UserNotexistException();

    }
}
