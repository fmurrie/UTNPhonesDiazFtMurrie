package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/province")
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
    @GetMapping("/")
    ResponseEntity<List<Province>> getAllProvinces()
    {
        List<Province> provinceList = service.getAll();
        if(provinceList.size() > 0 )
            return ResponseEntity.ok(service.getAll());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idProvince}")
    ResponseEntity<Optional<Province>> getProvinceById(@PathVariable Integer idProvince) {
        Optional<Province> province = service.getById(idProvince);
        if(province != null)
             return ResponseEntity.ok(province);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //endregion
}
