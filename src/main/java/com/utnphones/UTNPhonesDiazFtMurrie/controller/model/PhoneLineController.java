package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Controller
public class PhoneLineController implements LocationInterface<PhoneLine> {

    //region Properties:
    private final PhoneLineService phoneLineService;
    //endregion

    //region Constructors:
    @Autowired
    public PhoneLineController(PhoneLineService service) {
        this.phoneLineService = service;
    }
    //endregion

    //region Methods:
    public PhoneLine addPhoneLine(@RequestBody @Valid PhoneLine phoneLine) throws UserNotexistException, LineTypeNotExistsException, Exception {
        return phoneLineService.addPhoneLine(phoneLine);
    }

    public List<PhoneLine> getAllPhoneLines() throws PhoneLineException {
        return  phoneLineService.getAll();
    }

    public PhoneLine getPhoneLine(@PathVariable Integer idPhoneLine) throws PhoneLineException {
        return phoneLineService.getPhoneLine(idPhoneLine).get();

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

    public PhoneLine suspendPhoneLine(Integer idPhoneLine) throws PhoneLineException {
        return phoneLineService.suspendPhoneLine(idPhoneLine);
    }

    public PhoneLine enablePhoneLine(Integer idPhoneLine) throws PhoneLineException {
        return phoneLineService.enablePhoneLine(idPhoneLine);
    }

    public PhoneLine deletePhoneLine(Integer idPhoneLine) throws PhoneLineException {
        return phoneLineService.deletePhoneLine(idPhoneLine);
    }
    //endregion
}
