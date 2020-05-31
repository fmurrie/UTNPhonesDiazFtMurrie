package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userType")
public class UserTypeController {
    //Properties:
    private final UserTypeService userTypeService;

    //Constructors:
    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    //Methods:
    @PostMapping("/")
    public void addUserType(@RequestBody @Valid UserType userType) {
        userTypeService.add(userType);
    }

    @GetMapping("/")
    List<UserType> getAllUserTypes() {
        return userTypeService.getAll();
    }

    @GetMapping("/{idUserType}")
    ResponseEntity<Optional<UserType>> getUserTypeById(@PathVariable Integer idUserType) { return ResponseEntity.ok(userTypeService.getById(idUserType)); }

}
