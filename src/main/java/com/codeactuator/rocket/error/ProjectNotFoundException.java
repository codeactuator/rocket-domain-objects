package com.codeactuator.rocket.error;

public class ProjectNotFoundException extends RuntimeException {

    private String message;

    public ProjectNotFoundException(String message){
        super(message);
    }

    public String getMessage(){
        return this.message;
    }
}
