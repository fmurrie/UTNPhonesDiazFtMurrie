package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class SessionNotExistsException extends Throwable{

    public SessionNotExistsException() {
        super();
    }

    public String getMessage() {
        return "The session does not exist!";
    }
}
