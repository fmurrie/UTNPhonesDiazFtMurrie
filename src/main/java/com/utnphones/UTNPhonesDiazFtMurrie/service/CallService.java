package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CallDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.PhoneLineDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.GetCallRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CallService {

    //region Properties:
    private final CallDao dao;
    private final UserDao userDao;
    PhoneLineDao phoneLineDao;
    //endregion

    //Constructors:
    @Autowired
    public CallService (CallDao dao, UserDao userDao, PhoneLineDao phoneLineDao) {
        this.dao = dao;
        this.userDao=userDao;
        this.phoneLineDao = phoneLineDao;
    }

    //Methods:
    public Call addCall(CallAddRequestDto callDto) throws PhoneLineException{
        Call call = new Call();
        Integer idOrigin = callDto.getPhoneLineOrigin().getIdPhoneLine();
        Integer idDestiny = callDto.getPhoneLineDestiny().getIdPhoneLine();
        if(phoneLineDao.existsById(idOrigin)){
            if(phoneLineDao.existsById(idDestiny)){
                call.setPhoneLineOrigin(callDto.getPhoneLineOrigin());
                call.setPhoneLineDestiny(callDto.getPhoneLineDestiny());
                call.setInitTime(callDto.getInitTime());
                call.setEndTime(callDto.getEndTime());
                return dao.save(call);
            }
            else
                throw new PhoneLineException("ERROR! The origin line does not exists!");
        }
        else
            throw new PhoneLineException("ERROR! The destiny line does not exists!");
    }


    public List<Call> getCallsByUser(Integer userId) throws UserNotexistException
    {
        if(dao.existsById(userId))
            return dao.getCallsByUser(userId);
        else
            throw new UserNotexistException();
    }

    public Call getCallById(Integer id)
    {
        return dao.findById(id).get();
    }

    public List<Call> getCallsBetweenDates(Integer userId, GetCallRequestDto callRequestDto) throws UserNotexistException {
        List<Call> callList = new ArrayList<>();
        if(userDao.existsById(userId))
            callList = dao.getCallsBetweenDates(userId, callRequestDto.getInitDate(), callRequestDto.getEndDate());
        else
            throw new UserNotexistException();

        return callList;
    }


















            /*for (Call c : callList) {
                callQueryResult.add(


                    callQueryResult.builder().idCall(c.getIdCall()).originLine(c.getOriginLine())
                            .destinationLine(c.getDestinationLine()).callDate(c.getCallDate())
                            .idRate(c.getRate().getIdRate()).callDuration(c.getCallDuration())
                            .callCost(c.getCallCost()).callPrice(c.getCallPrice())
                            .idBill(c.getBill().getIdBill()).build());
            }*/
}
