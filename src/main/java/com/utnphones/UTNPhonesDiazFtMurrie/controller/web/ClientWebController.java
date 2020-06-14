package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import ch.qos.logback.core.net.server.Client;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserAlreadyExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class ClientWebController {

    //Properties:
    private final SessionManager sessionManager;
    private final UserController userController;
    private final AdviceController adviceController;

    @Autowired
    public ClientWebController(SessionManager sessionManager, UserController userController, AdviceController adviceController){
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.adviceController = adviceController;
    }

    @GetMapping("/currentUser")
    ResponseEntity getCurrentUser(@RequestHeader("Authorization") String token) throws UserNotexistException {
        User currentUser = sessionManager.getCurrentUser(token);
        if (currentUser != null){
            Integer id = currentUser.getIdUser();
            ResponseEntity<Optional<User>> response = userController.getUserById(id);
            if (response != null)
                return response;
            else
                return ResponseEntity.ok(adviceController.handleUserNotExists());
        } else
            return ResponseEntity.ok(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;

    }

    @PutMapping("/update")
    public ResponseEntity updateUser (@RequestHeader("Authorization") String token, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
        User user = sessionManager.getCurrentUser(token);
            if (user != null) {
                if (updatedUser != null){
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setCity(updatedUser.getCity());
                    user.setUsername(updatedUser.getUsername());
                    user.setUserpassword(updatedUser.getUserpassword());
                }
                else
                    return ResponseEntity.ok(adviceController.handleValidationException(new ValidationException("Error: check your fields and try again")));

                ResponseEntity response = userController.updateUser(user);
                if(response != null)
                    return response;
                else
                    return ResponseEntity.ok(adviceController.handleValidationException(new ValidationException("Error: the username is alredy in use")));
             }else
                 return ResponseEntity.ok(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;


    }
}
