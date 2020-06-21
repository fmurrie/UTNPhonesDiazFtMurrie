package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.compositekey.RateId;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Rate;
import com.utnphones.UTNPhonesDiazFtMurrie.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
public class RateController
{
    //region Properties:
    private final RateService service;
    //endregion

    //region Constructors:
    @Autowired
    public RateController(RateService service) {
        this.service = service;
    }
    //endregion

    //region Methods:
    public List<Rate> getAllRates()
    {
        return service.getAll();
    }

    public Optional<Rate> getRateById(Integer idOriginCity,Integer idDestinyCity) { return service.getById(new RateId(idOriginCity,idDestinyCity)); }
    //endregion
}
