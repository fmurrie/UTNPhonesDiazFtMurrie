package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class UserTypeController {
    //Properties:
    private final UserTypeService service;

    //Constructors:
    @Autowired
    public UserTypeController(UserTypeService service) {
        this.service = service;
    }

    //Methods:
    public ResponseEntity<UserType> addUserType(@RequestBody @Valid UserType userType) {
        return ResponseEntity.ok(service.add(userType));
    }

    List<UserType> getAllUserTypes() {
        return service.getAll();
    }


    public UserType getUserTypeById(Integer idUserType) { return service.getById(idUserType); }

}
