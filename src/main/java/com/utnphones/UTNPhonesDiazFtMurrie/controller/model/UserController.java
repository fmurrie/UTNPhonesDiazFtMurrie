package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController implements LocationInterface<User> {

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
    public User addUser(@RequestBody  User user) throws ValidationException {
        return service.addUser(user);
    }

    public List<User> getAllUsers() {
        return service.getAll();
    }

    public List<User> getAllClients() {
        return service.getAllClients();
    }

    public User getUserById(Integer idUser) throws UserNotexistException { return service.getUserById(idUser); }
    
    public User login(String username, String password) throws UserNotexistException, ValidationException {
        if ((username != null) && (password != null)) {
            return service.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

    public ResponseEntity updateUser (Integer userId, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
            return ResponseEntity.ok(service.updateUser(userId,updatedUser));
    }

    @Override
    public URI getLocation (User user){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getIdUser())
                .toUri();
    }
}