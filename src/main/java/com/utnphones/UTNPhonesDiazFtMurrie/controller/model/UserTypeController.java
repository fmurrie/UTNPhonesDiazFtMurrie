package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
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
    private final UserTypeService service;

    //Constructors:
    @Autowired
    public UserTypeController(UserTypeService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<UserType> addUserType(@RequestBody @Valid UserType userType) {
        return ResponseEntity.ok(service.add(userType));
    }

    @GetMapping("/")
    List<UserType> getAllUserTypes() {
        return service.getAll();
    }

    @GetMapping("/{idUserType}")
    ResponseEntity<Optional<UserType>>getUserTypeById(@PathVariable Integer idUserType) { return ResponseEntity.ok(service.getById(idUserType)); }

}
