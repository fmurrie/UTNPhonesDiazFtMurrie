package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class UserNotexistException extends Exception {

    public String getMessage(){
        return "ERROR! The user does not exists!";
    }
}
