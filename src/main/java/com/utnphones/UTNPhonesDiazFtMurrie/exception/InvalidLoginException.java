package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class InvalidLoginException extends Throwable {
    public InvalidLoginException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return "Invalid login";
    }
}
