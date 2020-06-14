package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.ErrorResponseDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.InvalidLoginException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.SessionNotExistsException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.UserNotexistException;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import org.hibernate.SessionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidLoginException.class)
    public ErrorResponseDto handleLoginException(InvalidLoginException exc) {
        return new ErrorResponseDto(1, "Invalid login");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorResponseDto handleValidationException(ValidationException exc) {
        return new ErrorResponseDto(2, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotexistException.class)
    public ErrorResponseDto handleUserNotExists() {
        return new ErrorResponseDto(3, "User not exists");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleSessionNotExists(SessionNotExistsException sessionNotExistsException) {
        return new ErrorResponseDto(400, sessionNotExistsException.getMessage());
    }
}
