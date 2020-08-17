package com.codeactuator.rocket.exception;

public class ProjectNotFoundException extends RuntimeException {

    private String message;

    public ProjectNotFoundException(String message){
        super("Could not found the Project: "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
