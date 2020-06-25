package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.BillDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.NoContentException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService
{
    //region Properties:
    private final BillDao billDao;
    private final UserDao userDao;
    //endregion

    //region Constructors:
    @Autowired
    public BillService (BillDao billDao,UserDao userDao) {
        this.billDao = billDao;
        this.userDao = userDao;
    }
    //endregion

    //region Methods:
    public Optional<Bill> getById(Integer  idBill) { return billDao.findById(idBill); }

    public List<Bill> getBillsByUser(Integer userId) throws UserNotExistException, ValidationException, NoContentException {
        if(userDao.existsById(userId))
        {
            User user = userDao.findById(userId).get();
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the bills of this user!");

            List<Bill> bills = billDao.getBillsByUser(userId);
            if(bills.size() == 0)
                throw new NoContentException("Ops! You do not have bills yet");
            return bills;
        }
        else
            throw new UserNotExistException();
    }

    public List<Bill> getBillsBetweenDates(Integer userId, Date fromDate, Date toDate) throws UserNotExistException, ValidationException, NoContentException {
        if(userDao.existsById(userId)) {
            User user = userDao.findById(userId).get();
            if (user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the calls of this user!");

            List<Bill> bills = billDao.getBillsBetweenDates(userId, fromDate, toDate);
            if(bills.size() == 0)
                throw new NoContentException("Ops! You do not have bills yet");
            return bills;
        }
        else
            throw new UserNotExistException();
    }

    //endregion
}
