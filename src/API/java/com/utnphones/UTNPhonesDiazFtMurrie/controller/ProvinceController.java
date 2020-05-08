package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.Country;
import com.utnphones.UTNPhonesDiazFtMurrie.model.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CountryService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("province/")
public class ProvinceController {

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping("/")
    public void addProvince(@RequestBody @Valid Province province) {
        provinceService.add(province);
    }

    @GetMapping("/")
    List<Province> getProvince(String name) {
        return provinceService.getProvince(name);
    }
}
