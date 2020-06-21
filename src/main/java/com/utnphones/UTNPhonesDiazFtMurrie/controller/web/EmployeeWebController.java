package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.PhoneLineController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserTypeController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("api/backoffice")
public class EmployeeWebController {

    private final SessionManager sessionManager;
    private final UserController userController;
    private final AdviceController adviceController;
    private final UserTypeController userTypeController;
    private final PhoneLineController phoneLineController;

    @Autowired
    public EmployeeWebController(SessionManager sessionManager, UserController userController,
                                 AdviceController adviceController, UserTypeController userTypeController,
                                 PhoneLineController phoneLineController){

        this.sessionManager = sessionManager;
        this.userController = userController;
        this.adviceController = adviceController;
        this.userTypeController = userTypeController;
        this.phoneLineController = phoneLineController;
    }

    //Methods:
    @PostMapping("/client")
    public ResponseEntity addClient(@RequestHeader("Authorization") String token, @RequestBody User user) throws ValidationException {
           try{
               UserType userTypeAux = userTypeController.getUserTypeById(user.getUserType().getIdUserType());
               if(userTypeAux != null){
                   if(userTypeAux.getDescription().equals("Client")){
                       userController.addUser(user);
                       return ResponseEntity.created(userController.getLocation(user)).build();
                   }
                   else
                       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleAddUserException(new AddUserException()));
               }
               else
                   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserTypeNotExists());
           }
           catch(ValidationException exc){
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(exc));
           }
    }

    @GetMapping("/me")
    ResponseEntity getCurrentUser(@RequestHeader("Authorization") String token) throws UserNotexistException {
        User currentUser = sessionManager.getCurrentUser(token);
        if (currentUser != null){
            Integer id = currentUser.getIdUser();
            User user = userController.getUserById(id);
            if (user != null)
                return ResponseEntity.ok(user);
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(new UserNotexistException()));
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adviceController.handleSessionNotExists(new SessionNotExistsException())) ;

    }

    @GetMapping("/clients")
    public ResponseEntity getClients(@RequestHeader("Authorization") String token, @RequestParam(required = false) Integer idClient) {
            ResponseEntity response = ResponseEntity.ok(userController.getClients());
            if (null != response)
                return response;
            else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleValidationException(new ValidationException("Sorry! no clients have been added yet!")));
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity getClient(@RequestHeader("Authorization") String token, @PathVariable Integer idClient) throws UserNotexistException, ValidationException {
       try{
           ResponseEntity response = ResponseEntity.ok(userController.getClientById(idClient));
           if (null != response)
               return response;
           else
               return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleValidationException(new ValidationException("Sorry! no clients have been added yet!")));
       }
       catch(UserNotexistException exc){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
       }
       catch(ValidationException exc){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(exc));
       }

    }

    @PutMapping("/client/{idUser}")
    public ResponseEntity updateClient (@RequestHeader("Authorization") String token, @PathVariable Integer idUser, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
        try {
            return ResponseEntity.ok(userController.updateUser(idUser, updatedUser));
        } catch (ValidationException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(exc));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @PutMapping("/client/{idUser}/suspension")
    public ResponseEntity suspendUser (@RequestHeader("Authorization") String token, @PathVariable Integer idUser)   {
        try {
            return ResponseEntity.ok(userController.suspendUser(idUser));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @PutMapping("/client/{idUser}/enable")
    public ResponseEntity enableUser (@RequestHeader("Authorization") String token, @PathVariable Integer idUser) throws UserNotexistException {
        try {
            return ResponseEntity.ok(userController.enableUser(idUser));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    @DeleteMapping("/client/{idUser}/elimination")
    public ResponseEntity deleteUser (@RequestHeader("Authorization") String token, @PathVariable Integer idUser) throws UserNotexistException {
        try {
            return ResponseEntity.ok(userController.deleteUser(idUser));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    //////////////////////////////////PHONE LINES///////////////////////////////////////////

    @PostMapping("/phoneLine")
    public ResponseEntity AddPhoneLine(@RequestHeader("Authorization") String token, @RequestBody PhoneLine phoneLine) {
        try{
            phoneLineController.addPhoneLine(phoneLine);
            return ResponseEntity.created(phoneLineController.getLocation(phoneLine)).build();
        }
        catch(LineTypeNotExistsException  exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleLineTypeNotExists(exc));
        }
        catch(UserNotexistException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
        catch(Exception exc)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneNumberExists());
        }
    }

    @GetMapping("/phoneLine/{idPhoneLine}")
    ResponseEntity getPhoneLine(@RequestHeader("Authorization") String token,@PathVariable(required = false) Integer idPhoneLine) {
        try{
            return ResponseEntity.ok(phoneLineController.getPhoneLine(idPhoneLine));
        }
        catch(PhoneLineException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
    }

    @GetMapping("/phoneLines")
    public ResponseEntity getPhoneLines(@RequestHeader("Authorization") String token ) {
        try{
            return ResponseEntity.ok(phoneLineController.getAllPhoneLines());
        }
        catch (PhoneLineException exc) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handlePhoneLineException(exc));
        }
    }

    @PutMapping("/phoneLine/{idPhoneLine}/suspension")
    public ResponseEntity suspendPhoneLine (@RequestHeader("Authorization") String token, @PathVariable Integer idPhoneLine)   {
        try {
            return ResponseEntity.ok(phoneLineController.suspendPhoneLine(idPhoneLine));
        } catch (PhoneLineException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
    }

    @PutMapping("/phoneLine/{idPhoneLine}/enable")
    public ResponseEntity enablePhoneLine (@RequestHeader("Authorization") String token, @PathVariable Integer idPhoneLine) {
        try {
            return ResponseEntity.ok(phoneLineController.enablePhoneLine(idPhoneLine));
        } catch (PhoneLineException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
    }

    @DeleteMapping("/phoneLine/{idPhoneLine}/elimination")
    public ResponseEntity deletePhoneLine (@RequestHeader("Authorization") String token, @PathVariable Integer idPhoneLine)  {
        try {
            return ResponseEntity.ok(phoneLineController.deletePhoneLine(idPhoneLine));
        } catch (PhoneLineException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handlePhoneLineException(exc));
        }
    }

}
