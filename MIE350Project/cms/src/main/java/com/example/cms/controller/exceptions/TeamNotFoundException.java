package com.example.cms.controller.exceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String code){
        super("Could not find team " + code);
    }
}
