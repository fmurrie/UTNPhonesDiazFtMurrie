package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.PhoneLineController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.GetCallRequestDto;
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

@RestController
@RequestMapping("api/client")
public class ClientWebController
{
    //region Properties:
    private final SessionManager sessionManager;
    private final UserController userController;
    private final PhoneLineController phoneLineController;
    private final CallController callController;
    private final AdviceController adviceController;
    //endregion

    //region Constructors:
    @Autowired
    public ClientWebController(SessionManager sessionManager, UserController userController, PhoneLineController phoneLineController ,CallController callController, AdviceController adviceController)
    {
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.phoneLineController = phoneLineController;
        this.callController = callController;
        this.adviceController = adviceController;
    }
    //endregion

    //region Methods:
    @GetMapping("/")
    ResponseEntity getCurrentUser(@RequestHeader("Authorization") String token)
    {
        try
        {
            User currentUser = sessionManager.getCurrentUser(token);

            if (currentUser != null)
            {
                Integer id = currentUser.getIdUser();
                User user = userController.getUserById(id);
                return ResponseEntity.ok(user);
            }
            else
            {
                return ResponseEntity.ok(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;
            }
        }
        catch (UserNotexistException exc)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adviceController.handleUserNotExists(exc));
        }
    }

    @PutMapping("/")
    public ResponseEntity updateUser (@RequestHeader("Authorization") String token, @RequestBody @Valid UserUpdateRequestDto updatedUser){
        try {
            return ResponseEntity.ok(userController.updateUser(sessionManager.getCurrentUser(token).getIdUser(), updatedUser));
        } catch (ValidationException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(exc));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @GetMapping("/phoneLine/favoriteDestinataries")
    public ResponseEntity top10UserDestinataries (@RequestHeader("Authorization") String token, @PathVariable Integer idUser){
        try{
            return ResponseEntity.ok(phoneLineController.top10Destinataries(idUser));
        }
        catch(UserNotexistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @GetMapping("/calls")
    public ResponseEntity getUserCalls(@RequestHeader("Authorization") String token){
        try{
            return ResponseEntity.ok(callController.getCallsByUser(sessionManager.getCurrentUser(token).getIdUser()));
        }
        catch(UserNotexistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @GetMapping("/calls/dates")
    public ResponseEntity getUserCalls(@RequestHeader("Authorization") String token,@RequestBody @Valid GetCallRequestDto getCallRequestDto){
        try{
            return ResponseEntity.ok(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getCallRequestDto));
        }
        catch(UserNotexistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }
    //endregion
}
