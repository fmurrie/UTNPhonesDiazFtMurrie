package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public PhoneLine addPhoneLine(PhoneLine phoneLine) throws LineTypeNotExistsException, DataIntegrityViolationException, UserNotExistException, ValidationException {
        return phoneLineService.addPhoneLine(phoneLine);
    }

    public List<PhoneLine> getAllPhoneLines() throws PhoneLineException {
        return  phoneLineService.getAll();
    }

    public PhoneLine getPhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        return phoneLineService.getPhoneLine(idPhoneLine).get();

    }

    public List<LineAndCallsQuantityDto> top10Destinataries (Integer idUser) throws UserNotExistException, ValidationException {
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

    public PhoneLine suspendPhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        return phoneLineService.suspendPhoneLine(idPhoneLine);
    }

    public PhoneLine enablePhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        return phoneLineService.enablePhoneLine(idPhoneLine);
    }

    public PhoneLine deletePhoneLine(Integer idPhoneLine) throws PhoneLineException, ValidationException {
        return phoneLineService.deletePhoneLine(idPhoneLine);
    }
    //endregion
}
