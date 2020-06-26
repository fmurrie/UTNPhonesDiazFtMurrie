package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.CallAddRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.PhoneLineException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
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
public class InfrastructureWebController
{
    //region Properties:
    CallController callController;
    AdviceController adviceController;
    //endregion

    //region Constructors:
    @Autowired
    public InfrastructureWebController(CallController callController, AdviceController adviceController){
        this.callController = callController;
        this.adviceController = adviceController;
    }
    //endregion

    //region Methods:
    @PostMapping("/call")
    public ResponseEntity addCall (@RequestBody @Valid CallAddRequestDto callDto)  {
        try{
            Call call = new Call();
            call.setPhoneLineOrigin(callDto.getPhoneLineOrigin());
            call.setPhoneLineDestiny(callDto.getPhoneLineDestiny());
            call.setInitTime(callDto.getInitTime());
            call.setEndTime(callDto.getEndTime());

            callController.addCall(call);
            return ResponseEntity.created(callController.getLocation(call)).build();
        }
        catch(PhoneLineException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
        catch(Exception exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(new ValidationException("ERROR! invalid call")));
        }
    }
    //endregion
}
