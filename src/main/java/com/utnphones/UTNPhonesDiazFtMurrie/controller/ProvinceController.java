package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("province")
public class ProvinceController
{
    //Properties:
    private final ProvinceService provinceService;

    //Constructors:
    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    //Methods:
    @PostMapping("/")
    public void addProvince(@RequestBody @Valid Province province) {
        provinceService.add(province);
    }

    @GetMapping("/")
    List<Province> getProvince(String name) {
        return provinceService.getProvince(name);
    }
}
