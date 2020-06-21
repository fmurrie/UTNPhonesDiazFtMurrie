package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class UserAlreadyExistsException extends RecordExistsException {
    public UserAlreadyExistsException() {
        super();
    }

    public String getMessage() {
        return "The user already exist!";
    }

}