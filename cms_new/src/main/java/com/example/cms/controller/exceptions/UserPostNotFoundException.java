package com.example.cms.controller.exceptions;

public class UserPostNotFoundException extends RuntimeException{
    public UserPostNotFoundException(String SearchTerm) {
        super("Could not find userpost with regards to" + SearchTerm);
    }
}
