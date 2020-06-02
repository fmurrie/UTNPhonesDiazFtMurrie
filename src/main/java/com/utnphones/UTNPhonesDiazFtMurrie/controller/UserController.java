package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //Properties:


    private final UserService service;

    //Constructors:
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody  User user) throws UserAlreadyExistsException {
        User newUser =  service.addUser(user);

        return ResponseEntity.created(getLocation(newUser)).build();
    }

    @GetMapping("/")
    List<User> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{idUser}")
    ResponseEntity<Optional<User>> getUserById(@PathVariable Integer idUser) { return ResponseEntity.ok(service.getUserById(idUser)); }

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

    /*@GetMapping("/callsbydni")
    public List<UserCall> getCallsCountByDni(@RequestParam String dni) { return service.getCallsCountByDni(dni); }*/

    private URI getLocation (User user){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getIdUser())
                .toUri();
    }

    ////////////////////////////////////////////PARCIAL//////////////////////////////////////////////
    ////////////////////////////////////////////PARCIAL//////////////////////////////////////////////
    ////////////////////////////////////////////PARCIAL//////////////////////////////////////////////

    //endpoint que liste las personas con DNI impar/par pasado por parametro
    @GetMapping("/dni/{dni}")
    public ResponseEntity<List<User>> getUsersByDni(@PathVariable String dni) {
        return ResponseEntity.ok(service.getUsersByDni(dni));
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