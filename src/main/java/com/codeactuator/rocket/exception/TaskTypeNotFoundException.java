package com.codeactuator.rocket.exception;

public class TaskTypeNotFoundException extends RuntimeException{


    private String message;

    public TaskTypeNotFoundException(String message){
        super("Could not found the TaskType: "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
