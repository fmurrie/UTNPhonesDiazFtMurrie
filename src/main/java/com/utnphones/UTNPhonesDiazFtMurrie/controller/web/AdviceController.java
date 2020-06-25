package com.utnphones.UTNPhonesDiazFtMurrie.controller.web;

import com.utnphones.UTNPhonesDiazFtMurrie.dto.ErrorResponseDto;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {
    //region Methods:
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidLoginException.class)
    public ErrorResponseDto handleLoginException(InvalidLoginException exc) {
        return new ErrorResponseDto(401, "Invalid login");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorResponseDto handleValidationException(ValidationException exc) {
        return new ErrorResponseDto(400, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotExistException.class)
    public ErrorResponseDto handleUserNotExists(UserNotExistException exc) {
        return new ErrorResponseDto(400, exc.getMessage());
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AddUserException.class)
    public ErrorResponseDto handleAddUserException(AddUserException exc) {
        return new ErrorResponseDto(401, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserTypeNotExistsException.class)
    public ErrorResponseDto handleUserTypeNotExists() {
        return new ErrorResponseDto(400, "ERROR! UserType does not exists");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PhoneLineException.class)
    public ErrorResponseDto handlePhoneLineException(PhoneLineException exc) {
        return new ErrorResponseDto(400, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentException.class)
    public ErrorResponseDto handleNoContentException(NoContentException exc) {
        return new ErrorResponseDto(204, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LineTypeNotExistsException.class)
    public ErrorResponseDto handleLineTypeNotExists(LineTypeNotExistsException exc) {
        return new ErrorResponseDto(400, exc.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErrorResponseDto handlePhoneNumberExists() {
        return new ErrorResponseDto(400, "Sorry! then number already exists!");
    }
    //endregion
}
