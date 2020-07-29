package com.codeactuator.rocket.constants;

public class ErrorCodes {



    public enum PROJECT {

        PROJECT_NOT_FOUND("Could not find the project!");

        private String message;
        private PROJECT(String message){
            this.message = message;
        }

        @Override
        public String toString() {
            return  message;
        }
    }


    public enum WORKFORCE {

        WORKFORCE_NOT_FOUND("Could not find the workforce!");

        private String message;
        private WORKFORCE(String message){
            this.message = message;
        }

        @Override
        public String toString() {
            return  message;
        }
    }


}
