package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User addUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        return userService.addUser(user);
    }

    @GetMapping("{idUser}")
    public Optional<User> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
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
    @PostMapping("")
    public User login(String username, String password) throws UserNotexistException, ValidationException {
        if ((username != null) && (password != null)) {
            return userService.login(username, password);
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }
    public void updateUser(User user) throws UserNotexistException {
        userService.updateUser(user);
    }*/
}