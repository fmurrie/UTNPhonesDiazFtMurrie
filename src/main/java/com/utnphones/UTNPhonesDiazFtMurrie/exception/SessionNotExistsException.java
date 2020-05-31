package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class SessionNotExistsException extends Throwable{

    public SessionNotExistsException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return "The session does not exist!";
    }
}
