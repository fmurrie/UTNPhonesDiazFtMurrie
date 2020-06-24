package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class DniNotExistsException extends Throwable{

    public DniNotExistsException(){
        super();
    }

    public String getMessage(){return "ERROR! User has not been found with that DNI!";}
}
