package com.codeactuator.rocket.exception;

public class TaskLogNotFoundException extends RuntimeException {

    private String message;

    public TaskLogNotFoundException(String message){
        super("Could not found the TaskLog: "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
