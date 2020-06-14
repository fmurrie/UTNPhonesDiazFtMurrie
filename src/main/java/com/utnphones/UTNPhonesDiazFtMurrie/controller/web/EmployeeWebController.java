package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserTypeController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.AddUserException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.UserType;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/backoffice/employee")
public class EmployeeWebController {

    private final SessionManager sessionManager;
    private final UserController userController;
    private final AdviceController adviceController;
    private final UserTypeController userTypeController;

    @Autowired
    public EmployeeWebController(SessionManager sessionManager, UserController userController, AdviceController adviceController, UserTypeController userTypeController){
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.adviceController = adviceController;
        this.userTypeController = userTypeController;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity addUser(@RequestHeader("Authorization") String token, @RequestBody User user) throws ValidationException {
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
    public ResponseEntity getAllClients(@RequestHeader("Authorization") String token) {
        if (sessionManager.getCurrentUser(token) != null) {
            ResponseEntity response = ResponseEntity.ok(userController.getAllClients());
            if (null != response)
                return response;
            else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adviceController.handleSessionNotExists(new SessionNotExistsException()));
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleSessionNotExists(new SessionNotExistsException()));
    }

    @PutMapping("/{idUser}")
    public ResponseEntity updateUser (@RequestHeader("Authorization") String token, @PathVariable Integer idUser, @RequestBody @Valid UserUpdateRequestDto updatedUser) throws ValidationException, UserNotexistException {
        try {
            return ResponseEntity.ok(userController.updateUser(idUser, updatedUser));
        } catch (ValidationException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleValidationException(exc));
        } catch (UserNotexistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

}
