package com.codeactuator.rocket.exception;

public class TaskNotFoundException extends RuntimeException {

    private String message;

    public TaskNotFoundException(String message){
        super("Could not found the Task: "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
