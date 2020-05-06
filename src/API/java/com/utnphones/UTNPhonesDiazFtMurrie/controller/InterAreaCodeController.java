package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import com.utnphones.UTNPhonesDiazFtMurrie.service.InterAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("interAreaCode/")
public class InterAreaCodeController {

    private final InterAreaCodeService interAreaCodeService;

    @Autowired
    public InterAreaCodeController(InterAreaCodeService interAreaCodeService) {
        this.interAreaCodeService = interAreaCodeService;
    }

    @PostMapping("/")
    public void addInterAreaCode(@RequestBody @Valid InterAreaCode interAreaCode) {
        interAreaCodeService.add(interAreaCode);
    }

    @GetMapping("/")
    List<InterAreaCode> getInterAreaCodes() {
        return interAreaCodeService.getInterAreaCodes();
    }

}
