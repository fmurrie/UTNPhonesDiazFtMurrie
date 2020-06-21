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

    //region Properties:
    private SessionManager sessionManager;
    private final UserService service;
    //endregion

    //region Constructors:
    @Autowired
    public UserController(UserService service, SessionManager sessionManager) {
        this.service = service;
        this.sessionManager=sessionManager;
    }
    //endregion

    //region Methods:
    public User addUser(@RequestBody  User user) throws ValidationException {
        return service.addUser(user);
    }

    public List<User> getUsers() {
        return service.getAll();
    }

    public User getUserById(Integer idUser) throws UserNotexistException { return service.getUserById(idUser); }

    public List<User> getClients() {
        return service.getClients();
    }

    public User getClientById(Integer idClient) throws UserNotexistException, ValidationException { return service.getClientById(idClient); }
    
    public User login(String username, String password) throws UserNotexistException, ValidationException {
        if ((username != null) && (password != null)) {
            return service.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

    public User updateUser (Integer userId, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
            return service.updateUser(userId,updatedUser);
    }

    public User suspendUser(Integer idUser) throws UserNotexistException {
        return service.suspendUser(idUser);
    }

    public User enableUser(Integer idUser) throws UserNotexistException {
        return service.enableUser(idUser);
    }

    public User deleteUser(Integer idUser) throws UserNotexistException {
        return service.deleteUser(idUser);
    }

    @Override
    public URI getLocation (User user){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getIdUser())
                .toUri();
    }
    //endregion
}