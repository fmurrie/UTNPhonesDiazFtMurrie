package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class PhoneLineController implements LocationInterface<PhoneLine> {

    //Properties:

    private final PhoneLineService phoneLineService;

    //Constructors:
    @Autowired
    public PhoneLineController(PhoneLineService service) {
        this.phoneLineService = service;
    }

    //Methods:
   // @PostMapping("/")
    public ResponseEntity<PhoneLine> addPhoneLine(@RequestBody @Valid PhoneLine phoneLine) throws LineAlreadyExistsException {
        return ResponseEntity.created(getLocation(phoneLine)).build();
    }

    //@GetMapping("/")
    public ResponseEntity<List<PhoneLine>> getAllPhoneLines() {
        List<PhoneLine> phoneLineList = phoneLineService.getAll();
        if (phoneLineList.size() > 0)
            return ResponseEntity.ok(phoneLineList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //@GetMapping("/{idPhoneLine}")
    public ResponseEntity<Optional<PhoneLine>> getPhoneLineById(@PathVariable Integer idPhoneLine) {
        Optional<PhoneLine> phoneLine = phoneLineService.getPhoneLineById(idPhoneLine);
        if(phoneLine != null)
             return ResponseEntity.ok(phoneLine);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public List<LineAndCallsQuantityDto> top10Destinataries (@PathVariable Integer idUser) throws UserNotexistException {
        return phoneLineService.top10Destinataries(idUser);
    }


    @Override
    public URI getLocation(PhoneLine line) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{lineId}")
                .buildAndExpand(line.getIdPhoneLine())
                .toUri();
    }
}
