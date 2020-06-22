package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.BillController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.CallController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.PhoneLineController;
import com.utnphones.UTNPhonesDiazFtMurrie.controller.model.UserController;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.GetBetweenDatesRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.dto.UserUpdateRequestDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotExistException;
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
    private final BillController billController;
    private final AdviceController adviceController;

    //endregion

    //region Constructors:
    @Autowired
    public ClientWebController(SessionManager sessionManager, UserController userController, PhoneLineController phoneLineController,
                               CallController callController, BillController billController, AdviceController adviceController)
    {
        this.sessionManager = sessionManager;
        this.userController = userController;
        this.phoneLineController = phoneLineController;
        this.callController = callController;
        this.billController = billController;
        this.adviceController = adviceController;
    }
    //endregion

    //region Methods:
    @GetMapping("/me")
    ResponseEntity getCurrentUser(@RequestHeader("Authorization") String token)
    {
        try
        {
            User currentUser = sessionManager.getCurrentUser(token);
            Integer id = currentUser.getIdUser();
            User user = userController.getUserById(id);
            return ResponseEntity.ok(user);
        }
        catch (UserNotExistException exc)
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
        } catch (UserNotExistException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }

    //////////////////////////////////PHONE LINES///////////////////////////////////////////
    @GetMapping("/phoneLine/favoriteDestinataries")
    public ResponseEntity top10UserDestinataries (@RequestHeader("Authorization") String token){
        try{
            return ResponseEntity.ok(phoneLineController.top10Destinataries(sessionManager.getCurrentUser(token).getIdUser()));
        }
        catch(UserNotExistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
        catch(ValidationException exc){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(exc));
        }
    }

    @GetMapping("phoneLine/calls/between")
    public ResponseEntity getCalls(@RequestHeader("Authorization") String token,@RequestBody @Valid GetBetweenDatesRequestDto getBetweenDatesRequestDto){
        try{
            return ResponseEntity.ok(callController.getCallsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(), getBetweenDatesRequestDto.getInitDate(), getBetweenDatesRequestDto.getEndDate()));
        }
        catch(UserNotExistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
        catch(ValidationException exc){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(exc));
        }
    }


    /*@GetMapping("phoneLine/calls")
    public ResponseEntity getUserCalls(@RequestHeader("Authorization") String token){
        try{
            return ResponseEntity.ok(callController.getCallsByUser(sessionManager.getCurrentUser(token).getIdUser()));
        }
        catch(UserNotexistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
    }*/

    ///////////////////////////////////// BILLS ///////////////////////////////////////////

    @GetMapping("/bills")
    public ResponseEntity getBills(@RequestHeader("Authorization") String token){
        try{
            return ResponseEntity.ok(billController.getBillsByUser(sessionManager.getCurrentUser(token).getIdUser()));
        }
        catch(UserNotExistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
        catch(ValidationException exc){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(exc));
        }
    }

    @GetMapping("bills/between")
    public ResponseEntity getBillsBetweenDates(@RequestHeader("Authorization") String token,@RequestBody @Valid GetBetweenDatesRequestDto getBetweenDatesRequestDto){
        try{
            return ResponseEntity.ok(billController.getBillsBetweenDates(sessionManager.getCurrentUser(token).getIdUser(),getBetweenDatesRequestDto.getInitDate(),getBetweenDatesRequestDto.getEndDate()));
        }
        catch(UserNotExistException exc){return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adviceController.handleUserNotExists(exc));
        }
        catch(ValidationException exc){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(adviceController.handleValidationException(exc));
        }
    }

    //endregion
}
