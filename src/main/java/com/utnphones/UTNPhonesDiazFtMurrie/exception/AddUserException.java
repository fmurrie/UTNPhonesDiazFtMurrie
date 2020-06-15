package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class AddUserException extends Throwable{

    public AddUserException( ){super();}

    public String getMessage(){
        return "Sorry. You are not allowed to add this user.";
    }

}
