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
                return callDao.save(call);
            }
            else
                throw new PhoneLineException("ERROR! The origin line does not exists!");
        }
        else
            throw new PhoneLineException("ERROR! The destiny line does not exists!");
    }


    public List<Call> getCallsByUser(Integer userId) throws UserNotexistException
    {
        if(callDao.existsById(userId))
            return callDao.getCallsByUser(userId);
        else
            throw new UserNotexistException();
    }

    public Optional<Call> getCallById(Integer id)
    {
        return callDao.findById(id);
    }

    public List<Call> getCallsBetweenDates(Integer userId, GetCallRequestDto callRequestDto) throws UserNotexistException {
        List<Call> callList;
        if(userDao.existsById(userId))
            callList = callDao.getCallsBetweenDates(userId, callRequestDto.getInidDate(), callRequestDto.getEndDate());
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
