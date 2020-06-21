package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/infrastructure")
public class InfrastructureWebController {

    CallController callController;
    AdviceController adviceController;

    @Autowired
    public InfrastructureWebController(CallController callController, AdviceController adviceController){
        this.callController = callController;
        this.adviceController = adviceController;
    }

    @PostMapping("/call")
    public ResponseEntity addCall (@RequestBody @Valid CallAddRequestDto callDto) throws PhoneLineException {
        try{
            Call call = callController.addCall(callDto);
            return ResponseEntity.created(callController.getLocation(call)).build();
        }
        catch(PhoneLineException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
    }



}
