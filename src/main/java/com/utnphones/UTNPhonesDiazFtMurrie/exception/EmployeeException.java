package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class EmployeeException extends Throwable{

    public EmployeeException(){//Cuando un employee quiera eliminar otro employee o a un adm (si se diera el caso)
    }

    public String getMessage(String message) {
        return message;
    }
}
