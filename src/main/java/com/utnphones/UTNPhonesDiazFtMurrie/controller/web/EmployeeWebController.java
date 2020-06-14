package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/backoffice/user")
public class EmployeeWebController {

    private final SessionManager sessionManager;
    private final UserController userController;
    private final AdviceController adviceController;

    @Autowired
    public EmployeeWebController(SessionManager sessionManager, UserController userController, AdviceController adviceController){
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.adviceController = adviceController;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity addUser(@RequestHeader("Authorization") String token, @RequestBody User user) throws UserAlreadyExistsException {
        if(sessionManager.getCurrentUser(token) != null){
            ResponseEntity responseEntity= userController.addUser(user);
            if(responseEntity != null){
                return ResponseEntity.created(userController.getLocation(user)).build();
            }
            else
                return ResponseEntity.ok(adviceController.handleUserNotExists());
        }
        else
        {
            return ResponseEntity.ok(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;
        }
    }

}
