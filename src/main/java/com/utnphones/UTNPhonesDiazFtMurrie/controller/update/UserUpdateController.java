package com.utnphones.UTNPhonesDiazFtMurrie.controller.update;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/update")
public class UserUpdateController {

    private final UserController userController;
    private final SessionManager sessionManager;

    @Autowired
    public UserUpdateController(UserController userController, SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;

    }
    @PutMapping("/")
    public ResponseEntity update(@RequestHeader("Authorization") String sessionToken, @RequestBody @Valid UserUpdateRequestDto userUpdateRequestDto) throws SessionNotExistsException, ValidationException
    {
        ResponseEntity response;
        try {
            User updatedUser = sessionManager.getCurrentUser(sessionToken);
            if (updatedUser != null) {
                if (userUpdateRequestDto != null){
                    updatedUser.setFirstName(userUpdateRequestDto.getFirstName());
                    updatedUser.setLastName(userUpdateRequestDto.getLastName());
                    updatedUser.setCity(userUpdateRequestDto.getCity());
                    updatedUser.setUsername(userUpdateRequestDto.getUsername());
                    updatedUser.setUserpassword(userUpdateRequestDto.getUserpassword());
                }
                response = ResponseEntity.ok(userController.update(updatedUser));
            }
            else
                throw new UserNotexistException();

            return response;
        }
        catch(UserNotexistException e){
            throw new SessionNotExistsException(e);
        }
    }

}
