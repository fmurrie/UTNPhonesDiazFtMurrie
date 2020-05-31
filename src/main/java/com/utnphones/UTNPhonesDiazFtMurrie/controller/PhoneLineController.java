package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(phoneLineService.getAll());
    }

    @GetMapping("/{idPhoneLine}")
    public ResponseEntity<Optional<PhoneLine>> getPhoneLineById(@PathVariable Integer idPhoneLine) { return ResponseEntity.ok(phoneLineService.getPhoneLineById(idPhoneLine)); }

}
