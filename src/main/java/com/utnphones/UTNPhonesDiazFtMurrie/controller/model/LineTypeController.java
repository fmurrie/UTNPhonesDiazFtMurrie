package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.LineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    //region Properties:
    private final LineTypeService service;
    //endregion

    //region Constructors:
    @Autowired
    public LineTypeController(LineTypeService service) {
        this.service = service;
    }
    //endregion

    //region Methods:
    @GetMapping("/")
    public ResponseEntity<List<LineType>> getAllLineTypes() {
        List<LineType> lineTypeList = service.getAll();
        if(lineTypeList.size() > 0)
            return ResponseEntity.ok(lineTypeList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/{idLineType}")
    ResponseEntity<Optional<LineType>> getLineTypeById(@PathVariable Integer idLineType) {
        Optional<LineType> lineType = service.getLineById(idLineType);
        if(lineType != null)
            return ResponseEntity.ok(lineType);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //endregion
}

