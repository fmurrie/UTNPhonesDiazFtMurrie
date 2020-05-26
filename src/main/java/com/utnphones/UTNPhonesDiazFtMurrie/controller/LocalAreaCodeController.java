package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.LocalAreaCode;
import com.utnphones.UTNPhonesDiazFtMurrie.service.LocalAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("localAreaCode/")
public class LocalAreaCodeController {

    private final LocalAreaCodeService localAreaCodeService;

    @Autowired
    public LocalAreaCodeController(LocalAreaCodeService localAreaCodeService) {
        this.localAreaCodeService = localAreaCodeService;
    }

    @PostMapping("/")
    public void addLocalAreaCode(@RequestBody @Valid LocalAreaCode localAreaCode) {
        localAreaCodeService.add(localAreaCode);
    }

    @GetMapping("/")
    List<LocalAreaCode> getLocalAreaCode(@RequestParam(required = false) String code) {
        return localAreaCodeService.getLocalAreaCode(code);
    }

}
