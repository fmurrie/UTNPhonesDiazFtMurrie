package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.BillDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
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
    //endregion

    //region Constructors:
    @Autowired
    public BillService (BillDao billDao) {
        this.billDao = billDao;
    }
    //endregion

    //region Methods:
    public Optional<Bill> getById(Integer  idBill) { return billDao.findById(idBill); }

    public List<Bill> getBillsByUser(Integer userId){ return billDao.getBillsByUser(userId); }

    public List<Bill> getBillsBetweenDates(Integer userId, Date fromDate, Date toDate){ return billDao.getBillsBetweenDates(userId, fromDate, toDate); }
    //endregion
}
