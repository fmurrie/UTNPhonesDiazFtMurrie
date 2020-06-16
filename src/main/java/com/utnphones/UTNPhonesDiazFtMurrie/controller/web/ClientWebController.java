package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.PhoneLineController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.LineAndCallsQuantityDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user/client")
public class ClientWebController {

    //Properties:
    private final SessionManager sessionManager;
    private final UserController userController;
    private final PhoneLineController phoneLineController;
    private final AdviceController adviceController;

    @Autowired
    public ClientWebController(SessionManager sessionManager, UserController userController, PhoneLineController phoneLineController ,AdviceController adviceController){
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.phoneLineController = phoneLineController;
        this.adviceController = adviceController;
    }

    @GetMapping("/me")
    ResponseEntity getCurrentUser(@RequestHeader("Authorization") String token) throws UserNotexistException {
        try{
            User currentUser = sessionManager.getCurrentUser(token);
            if (currentUser != null){
                Integer id = currentUser.getIdUser();
                User user = userController.getUserById(id);
                return ResponseEntity.ok(user);
            } else
                return ResponseEntity.ok(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;

        }catch (UserNotexistException exc){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adviceController.handleUserNotExists(exc));
        }
    }

    @PutMapping("/me")
    public ResponseEntity updateUser (@RequestHeader("Authorization") String token, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
        try {
            return ResponseEntity.ok(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(), updatedUser));
        } catch (ValidationException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(exc));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @GetMapping("me/phoneLine/favoriteDestinataries")
    public ResponseEntity top10UserDestinataries (@RequestHeader("Authorization") String token, @PathVariable Integer idUser) throws UserNotexistException {
        try{
            return ResponseEntity.ok(phoneLineController.top10Destinataries(idUser));
        }
        catch(UserNotexistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }
}
