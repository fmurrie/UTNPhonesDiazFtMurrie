package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CallDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CallService {

    //region Properties:
    private final CallDao callDao;
    private final UserDao userDao;
    private final PhoneLineDao phoneLineDao;
    //endregion

    //Constructors:
    @Autowired
    public CallService (CallDao callDao, UserDao userDao, PhoneLineDao phoneLineDao)
    {
        this.callDao = callDao;
        this.userDao=userDao;
        this.phoneLineDao = phoneLineDao;
    }

    //Methods:
    public Call addCall(Call call) throws PhoneLineException, Exception{
        Integer idOrigin = call.getPhoneLineOrigin().getIdPhoneLine();
        Integer idDestiny = call.getPhoneLineDestiny().getIdPhoneLine();
        PhoneLine origin = phoneLineDao.findById(idOrigin).get();
        PhoneLine destiny = phoneLineDao.findById(idDestiny).get();
        if(phoneLineDao.existsById(idOrigin)){
            if(phoneLineDao.existsById(idDestiny)){
                if(origin.isDeleted() || origin.isSuspended())
                    throw new PhoneLineException("ERROR! The origin line is suspend or deleted!");
                if(destiny.isDeleted() || destiny.isSuspended())
                    throw new PhoneLineException("ERROR! The destiny line is suspend or deleted!");
                //if(call.getInitTime().compareTo(call.getEndTime()) )

                     return callDao.save(call);
            }
            else
                throw new PhoneLineException("ERROR! The destiny line does not exists!");
        }
        else
            throw new PhoneLineException("ERROR! The origin line does not exists!");
    }


    public List<Call> getCallsByUser(Integer userId) throws UserNotExistException, ValidationException {
        if(userDao.existsById(userId)){
            User user = userDao.findById(userId).get();
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the calls of this user!");

            return callDao.getCallsByUser(userId);
        }
        else
            throw new UserNotExistException();
    }

    public Optional<Call> getCallById(Integer id) throws ValidationException, UserNotExistException {

        if(userDao.existsById(id)){
            User user = userDao.findById(id).get();
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the calls of this user!");
            return callDao.findById(id);
        }
        else
            throw new UserNotExistException();

    }

    public List<Call> getCallsBetweenDates(Integer userId, Date initTime, Date endDate) throws UserNotExistException, ValidationException, NoContentException {
        List<Call> callList;
        if(userDao.existsById(userId)) {
            User user = userDao.findById(userId).get();
            if (user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the calls of this user!");
            callList = callDao.getCallsBetweenDates(userId, initTime, endDate);
        }
        else
            throw new UserNotExistException();
        if(callList.size() == 0)
            throw new NoContentException("Ops! You do not have calls yet");
        return callList;
    }
}
