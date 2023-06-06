package com.spirngauth.authentication_spring.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debutMessage;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

     ApiError(HttpStatus status){
        this();
        this.status = status;
    }
     ApiError(HttpStatus status , Throwable ex){
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debutMessage = ex.getLocalizedMessage();
    }
     ApiError(HttpStatus status , String message, Throwable ex){
        this();
        this.status = status;
        this.message = message;
        this.debutMessage = ex.getLocalizedMessage();
    }    

    abstract class ApiSubError {

    }
    
    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    class ApiValidationError extends ApiSubError {
       private String object;
       private String field;
       private Object rejectedValue;
       private String message;
    
       ApiValidationError(String object, String message) {
           this.object = object;
           this.message = message;
       }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebutMessage() {
        return debutMessage;
    }

    public void setDebutMessage(String debutMessage) {
        this.debutMessage = debutMessage;
    }
}
