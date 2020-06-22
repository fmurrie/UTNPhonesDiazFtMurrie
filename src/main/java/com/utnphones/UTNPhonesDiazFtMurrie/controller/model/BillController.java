package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Bill;
import com.utnphones.UTNPhonesDiazFtMurrie.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class BillController
{

    //region Properties:
    private final BillService billService;
    //endregion

    //region Constructors:
    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }
    //endregion

    //region Methods:
    public List<Bill> getBillsByUser(Integer idUser) throws UserNotExistException, ValidationException {
        return billService.getBillsByUser(idUser);
    }

    public List<Bill> getBillsBetweenDates(Integer idUser, Date initDate, Date endDate) throws UserNotExistException, ValidationException {
        return billService.getBillsBetweenDates(idUser,initDate,endDate);
    }
    //endregion
}
