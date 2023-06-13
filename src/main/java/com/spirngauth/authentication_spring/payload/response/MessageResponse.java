package com.spirngauth.authentication_spring.payload.response;


import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class MessageResponse extends ResponseEntityExceptionHandler {
    private String message;
    private HttpStatus status;
    private int code = 200;
    // private Object payload;


    public int checkCode(int code){
        switch (code) {
            case 784076380: // User or password is wrong
                return 400;
            default:
                return 9999;
        }
    }

    public MessageResponse() {
    }

    
    public MessageResponse(String message,HttpStatus status,int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
    public MessageResponse(String message,HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    
    public MessageResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    


}
