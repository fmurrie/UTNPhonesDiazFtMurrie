package com.utnphones.UTNPhonesDiazFtMurrie.controller.dto;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class CallDtoController {

    CallController callController;

    @Autowired
    public CallDtoController(CallController callController) {
        this.callController = callController;
    }

    @PostMapping("/")
    public ResponseEntity<Call> addCall (@RequestBody CallAddRequestDto callDto){
        ResponseEntity responseEntity = null;
        Call call = new Call();
        if(callDto != null){
            call.setPhoneLineOrigin(callDto.getPhoneLineOrigin());
            call.setPhoneLineDestiny(callDto.getPhoneLineDestiny());
            call.setInitTime(callDto.getInitTime());
            call.setEndTime(callDto.getEndTime());
            responseEntity= ResponseEntity.ok(callController.addCall(call));
        }
        if(responseEntity != null)
            return responseEntity;
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
