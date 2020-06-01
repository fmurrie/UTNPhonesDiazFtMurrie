package com.utnphones.UTNPhonesDiazFtMurrie.controller;

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
    //Properties:
    private final ProvinceService service;

    //Constructors:
    @Autowired
    public ProvinceController(ProvinceService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<Province> addProvince(@RequestBody @Valid Province province) {
        return ResponseEntity.ok(service.add(province));
    }

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
}
