package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LoginRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.InvalidLoginException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class LoginController
{
    //region Properties:
    UserController userController;
    SessionManager sessionManager;
    AdviceController adviceController;
    //endregion

    //region Constructors:
    @Autowired
    public LoginController(UserController userController, SessionManager sessionManager,AdviceController adviceController) {
        this.userController = userController;
        this.sessionManager = sessionManager;
        this.adviceController = adviceController;
    }
    //endregion

    //region Methods:
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) throws  InvalidLoginException, ValidationException {
        try {
            ResponseEntity response;
            User u = userController.login(loginRequestDto.getUsername(), loginRequestDto.getUserpassword());
            String token = sessionManager.createSession(u);
            response = ResponseEntity.ok().headers(createHeaders(token)).build();
            return response;
        } catch (UserNotExistException exc) {
            throw new InvalidLoginException(exc);
        }
        catch(NoSuchAlgorithmException exc)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(new ValidationException("An error as occurred with the password!")));
        }
    }


    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {
            sessionManager.removeSession(token);
            return ResponseEntity.ok().build();
    }

    HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }
    //endregion
}
