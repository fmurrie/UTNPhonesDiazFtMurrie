package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.LineAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CallService;
import com.utnphones.UTNPhonesDiazFtMurrie.service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/call")
public class CallController {

    //Properties:

    private final CallService callService;

    //Constructors:
    @Autowired
    public CallController(CallService service) {

        this.callService = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<Call> addCall(@RequestBody @Valid Call call) {
        return ResponseEntity.ok(callService.addCall(call));
    }

    @GetMapping("/")
    public ResponseEntity<List<Call>> getAllCalls() {
        List<Call> callList = callService.getAll();
        if(callList.size() > 0)
            return ResponseEntity.ok(callList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idCall}")
    public ResponseEntity<Optional<Call>> getCallById(@PathVariable Integer idCall) {
        Optional<Call> callList = callService.getCallById(idCall);
        if (callList != null)
            return ResponseEntity.ok(callList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
