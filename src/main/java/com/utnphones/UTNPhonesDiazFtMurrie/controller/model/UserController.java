package com.utnphones.UTNPhonesDiazFtMurrie.controller.model;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.interfaces.LocationInterface;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class UserController implements LocationInterface<User> {

    //region Properties:
    private final UserService service;
    //endregion

    //region Constructors:
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    //endregion

    //region Methods:
    public User addUser(User user) throws ValidationException {
        return service.addUser(user);
    }

    public List<User> getUsers() {
        return service.getAll();
    }

    public User getUserById(Integer idUser) throws UserNotExistException { return service.getUserById(idUser).get(); }

    public List<User> getClients() {
        return service.getClients();
    }

    public User getClientById(Integer idClient) throws UserNotExistException, ValidationException { return service.getClientById(idClient).get(); }
    
    public User login(String username, String password) throws UserNotExistException, ValidationException {
        if ((username != null) && (password != null)) {
            return service.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

    public User updateUser (Integer userId,UserUpdateRequestDto updatedUser) throws ValidationException, UserNotExistException {
            return service.updateUser(userId,updatedUser);
    }

    public User suspendUser(Integer idUser) throws UserNotExistException {
        return service.suspendUser(idUser);
    }

    public User enableUser(Integer idUser) throws UserNotExistException {
        return service.enableUser(idUser);
    }

    public User deleteUser(Integer idUser) throws UserNotExistException {
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