package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineTypeNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
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
    public PhoneLine addPhoneLine(PhoneLine phoneLine) throws LineTypeNotExistsException, DataIntegrityViolationException, UserNotExistException, ValidationException {
        if (linetypeDao.existsById(phoneLine.getLineType().getIdLineType())){
            Integer idUser = phoneLine.getUser().getIdUser();
            if(userDao.existsById(idUser)){
                User user = userDao.findById(idUser).get();
                if(user.getUserType().getDescription().equals("Employee"))
                    throw new ValidationException("Sorry! You are not allowed to add this Line!");
                return phoneLineDao.save(phoneLine);
            }
            else
                throw new UserNotExistException();
        }
        else
            throw new LineTypeNotExistsException();
    }

    public List<PhoneLine> getAll() throws PhoneLineException {
        List<PhoneLine> phoneLineList = phoneLineDao.findAll();
        if(isNull(phoneLineList))
            throw new PhoneLineException("Sorry! no lines available yet");

        return phoneLineDao.findAll();
    }

    public Optional<PhoneLine> getPhoneLine(Integer id) throws PhoneLineException, ValidationException {
        if(phoneLineDao.existsById(id)) {
            Optional<PhoneLine> phoneLine = phoneLineDao.findById(id);
            Integer idUser = phoneLine.get().getUser().getIdUser();
            User user = userDao.findById(idUser).get();
            if (user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! You are not allowed to see this Line!");
            return phoneLine;

        }
        else
            throw new PhoneLineException("ERROR! The line does not exists");
    }

    public PhoneLine suspendPhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        User user = phoneLine.getUser();
        if(phoneLine != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! You are not allowed to suspend this phoneline!");
            phoneLine.setSuspended(true);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public PhoneLine enablePhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        User user = phoneLine.getUser();
        if(phoneLine != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! You are not allowed to enable this phoneline!");
            phoneLine.setSuspended(false);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public PhoneLine deletePhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        PhoneLine phoneLine = phoneLineDao.findById(idPhoneLine).get();
        User user = phoneLine.getUser();
        if(phoneLine != null){
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! You are not allowed to delete this phoneline!");
            phoneLine.setDeleted(true);
            return phoneLineDao.save(phoneLine);
        }
        else
            throw new PhoneLineException("Sorry! The phone line does not exist!");
    }

    public List<LineAndCallsQuantityDto> top10Destinataries(Integer userId) throws UserNotExistException, ValidationException {
        List<LineAndCallsQuantityDto> list = new ArrayList<>();
        if (userDao.existsById(userId)){
            User user = userDao.findById(userId).get();
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the favorite destinataries of this phoneline");
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
