package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class LineTypeNotExistsException extends Throwable{
    public LineTypeNotExistsException() {
        super();
    }

    public String getMessage() {
        return "The line type does not exist!";
    }

}
