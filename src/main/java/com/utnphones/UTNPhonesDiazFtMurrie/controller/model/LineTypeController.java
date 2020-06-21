package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.LineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class LineTypeController
{
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
    public List<LineType> getAllLineTypes() {
        return service.getAll();
    }

    public Optional<LineType> getLineTypeById(Integer idLineType) {
        return service.getLineById(idLineType);
    }
    //endregion
}

