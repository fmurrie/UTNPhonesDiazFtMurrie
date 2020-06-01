package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phoneLine")
public class PhoneLineController {

    //Properties:

    private final PhoneLineService phoneLineService;

    //Constructors:
    @Autowired
    public PhoneLineController(PhoneLineService service) {
        this.phoneLineService = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<PhoneLine> addPhoneLine(@RequestBody @Valid PhoneLine phoneLine) throws LineAlreadyExistsException {
        return ResponseEntity.ok(phoneLineService.addPhoneLine(phoneLine));
    }

    @GetMapping("/")
    public ResponseEntity<List<PhoneLine>> getAllPhoneLines() {
        List<PhoneLine> phoneLineList = phoneLineService.getAll();
        if (phoneLineList.size() > 0)
            return ResponseEntity.ok(phoneLineList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idPhoneLine}")
    public ResponseEntity<Optional<PhoneLine>> getPhoneLineById(@PathVariable Integer idPhoneLine) {
        Optional<PhoneLine> phoneLine = phoneLineService.getPhoneLineById(idPhoneLine);
        if(phoneLine != null)
             return ResponseEntity.ok(phoneLine);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
