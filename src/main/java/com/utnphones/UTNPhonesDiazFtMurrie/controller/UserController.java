package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //Properties:
    private SessionManager sessionManager;

    private final UserService service;

    //Constructors:
    @Autowired
    public UserController(UserService service, SessionManager sessionManager) {
        this.service = service;
        this.sessionManager=sessionManager;
    }

    //Methods:
    @PostMapping("/")
    public User addUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        return service.addUser(user);
    }

    @GetMapping("/")
    List<User> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{idUser}")
    ResponseEntity<Optional<User>> getUserTypeById(@PathVariable Integer idUser) { return ResponseEntity.ok(service.getUserById(idUser)); }

    @PostMapping("/login")
    public User login(String username, String password) throws UserNotexistException, ValidationException {
        if ((username != null) && (password != null)) {
            return service.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

    @PutMapping("/")
    public ResponseEntity update (@RequestBody @Valid User updatedUser) throws ValidationException, UserNotexistException {
        if(updatedUser!=null) {
            return ResponseEntity.ok(service.updateUser(updatedUser));
        } else {
            throw new ValidationException("User fields must have a value");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /*@PostMapping("removeAll/")
    public void removeUsers(List<User> userList) throws UserNotexistException {
        for (User u : userList) {
            userService.removeUser(u);
        }
    }
    @PostMapping("remove/")
    public void removeUser(User user) throws UserNotexistException {
        userService.removeUser(user);
    }
    */
}