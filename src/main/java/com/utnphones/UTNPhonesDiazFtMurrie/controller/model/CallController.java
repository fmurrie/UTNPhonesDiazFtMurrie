package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.GetCallRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@Controller
public class CallController implements LocationInterface<Call> {

    //region Properties:
    private CallService callService;
    //endregion

    //region Constructors:
    @Autowired
    public CallController(CallService service) {
        this.callService = service;
    }
    //endregion

    //region Methods:
    public Call addCall(CallAddRequestDto call) throws PhoneLineException {
        return callService.addCall(call);
    }

    public List<Call> getCallsByUser(Integer userId) throws UserNotexistException {
        return callService.getCallsByUser(userId);
    }

    public List<Call> getCallsBetweenDates(Integer userId, GetCallRequestDto callRequestDto) throws UserNotexistException{
        return callService.getCallsBetweenDates(userId,callRequestDto);
    }

    public Call getCallById(Integer idCall) {
        return callService.getCallById(idCall).get();
    }

    @Override
    public URI getLocation(Call call) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{callId}")
                .buildAndExpand(call.getIdCall())
                .toUri();
    }
    //endregion
}
