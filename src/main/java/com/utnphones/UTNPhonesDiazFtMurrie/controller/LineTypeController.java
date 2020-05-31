package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.LineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lineType")
public class LineTypeController {

    //Properties:
    private final LineTypeService service;

    //Constructors:
    @Autowired
    public LineTypeController(LineTypeService service) {
        this.service = service;
    }

    //Methods:

    @GetMapping("/")
    public ResponseEntity<List<LineType>> getAllLineTypes() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{idLineType}")
    ResponseEntity<Optional<LineType>> getLineTypeById(@PathVariable Integer idLineType) { return ResponseEntity.ok(service.getLineById(idLineType)); }

}

