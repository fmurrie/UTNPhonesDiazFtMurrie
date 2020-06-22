package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.BillDao;
import com.utnphones.UTNPhonesDiazFtMurrie.dao.UserDao;
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

    public List<Bill> getBillsByUser(Integer userId) throws UserNotExistException, ValidationException {
        User user = new User();
        if(billDao.existsById(userId))
        {
            user = userDao.findById(userId).get();
            if(user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the bills of this user!");

            return billDao.getBillsByUser(userId);
        }
        else
            throw new UserNotExistException();
    }

    public List<Bill> getBillsBetweenDates(Integer userId, Date fromDate, Date toDate) throws UserNotExistException, ValidationException {
        if(billDao.existsById(userId)) {
            User user = userDao.findById(userId).get();
            if (user.getUserType().getDescription().equals("Employee"))
                throw new ValidationException("Sorry! you are not allowed to see the calls of this user!");
            return billDao.getBillsBetweenDates(userId, fromDate, toDate);
        }
        else
            throw new UserNotExistException();
    }

    //endregion
}
