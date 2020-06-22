package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineTypeNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class PhoneLineService {

    //region Properties:
    private final PhoneLineDao phoneLineDao;
    private final UserDao userDao;
    private final LineTypeDao linetypeDao;
    //endregion

    //region Constructors:
    @Autowired
    public PhoneLineService(PhoneLineDao phoneLineDao, UserDao userDao, LineTypeDao linetypeDao) {
        this.phoneLineDao = phoneLineDao;
        this.userDao = userDao;
        this.linetypeDao = linetypeDao;
    }
    //endregion

    //region Methods:
    public PhoneLine addPhoneLine(PhoneLine phoneLine) throws LineTypeNotExistsException, DataIntegrityViolationException, UserNotExistException {
        if (linetypeDao.existsById(phoneLine.getLineType().getIdLineType()))
            if(userDao.existsById(phoneLine.getUser().getIdUser()))
                return phoneLineDao.save(phoneLine);
            else
                throw new UserNotExistException();
        else
            throw new LineTypeNotExistsException();
    }

    public List<PhoneLine> getAll() throws PhoneLineException {
        List<PhoneLine> phoneLineList = phoneLineDao.findAll();
        if(isNull(phoneLineList))
            throw new PhoneLineException("Sorry! no lines available yet");

        return phoneLineDao.findAll();
    }

    public Optional<PhoneLine> getPhoneLine(Integer id) throws PhoneLineException {
        if(phoneLineDao.existsById(id))
            return phoneLineDao.findById(id);
        else
            throw new PhoneLineException("ERROR! The line does not exists");
    }

    public PhoneLine suspendPhoneLine(Integer idPhoneLine) throws PhoneLineException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        if(phoneLine != null){
            phoneLine.setSuspended(true);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public PhoneLine enablePhoneLine(Integer idPhoneLine) throws PhoneLineException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        if(phoneLine != null){
            phoneLine.setSuspended(false);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public PhoneLine deletePhoneLine(Integer idPhoneLine) throws PhoneLineException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        if(phoneLine != null){
            phoneLine.setDeleted(true);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public List<LineAndCallsQuantityDto> top10Destinataries(Integer userId) throws UserNotExistException {
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
            throw new UserNotExistException();
    }
    //endregion
}
