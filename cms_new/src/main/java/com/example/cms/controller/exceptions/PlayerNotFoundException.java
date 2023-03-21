package com.example.cms.controller.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String name) {
        super("Could not find player " + name);
    }
}
