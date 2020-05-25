package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class CountryException extends Exception{

    @Override
    public String getMessage() {
        return "ERROR! The country already exists.";
    }
}
