package com.utnphones.UTNPhonesDiazFtMurrie.exception;

public class ProvinceException extends Exception{

    @Override
    public String getMessage() {
        return "ERROR! The province already exists.";
    }
}
