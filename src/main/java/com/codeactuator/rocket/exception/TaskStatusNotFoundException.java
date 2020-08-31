package com.codeactuator.rocket.exception;

public class TaskStatusNotFoundException extends RuntimeException {

    private String message;

    public TaskStatusNotFoundException(String message){
        super("Could not found the TaskStatus: "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
