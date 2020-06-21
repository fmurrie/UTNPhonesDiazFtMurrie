package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
public class ProvinceController
{
    //region Properties:
    private final ProvinceService service;
    //endregion

    //region Constructors:
    @Autowired
    public ProvinceController(ProvinceService service) {
        this.service = service;
    }
    //endregion

    //region Methods:
    public List<Province> getAllProvinces()
    {
        return service.getAll();
    }

    public Optional<Province> getProvinceById(Integer idProvince) {
        return service.getById(idProvince);
    }
    //endregion
}
