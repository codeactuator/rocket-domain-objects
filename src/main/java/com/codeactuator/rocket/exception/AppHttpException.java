package com.codeactuator.rocket.exception;

public class AppHttpException extends Exception {

    private final String HTTP_CODE;
    private final String MESSAGE;

    public AppHttpException(String httpCode, String message){
        this.HTTP_CODE = httpCode;
        this.MESSAGE = message;
    }

    public String getHttpCode(){
        return this.HTTP_CODE;
    }

    public String getMessage(){
        return this.MESSAGE;
    }
}
