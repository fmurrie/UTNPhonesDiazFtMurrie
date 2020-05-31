package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Province;
import com.utnphones.UTNPhonesDiazFtMurrie.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addProvince(@RequestBody @Valid Province province) {
        service.add(province);
    }

    @GetMapping("/")
    List<Province> getAllProvinces() {
        return service.getAll();
    }

    @GetMapping("/{idProvince}")
    ResponseEntity<Optional<Province>> getProvinceById(@PathVariable Integer idProvince) {
        return ResponseEntity.ok(service.getById(idProvince));
    }
}
