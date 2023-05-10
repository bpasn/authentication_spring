package com.spirngauth.authentication_spring.payload.response;

import com.spirngauth.authentication_spring.models.ECode;

public class MessageResponse {
    private String message;
    private ECode statusCode;
    // private Boolean status;
    // private Object payload;


    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }
    public MessageResponse(String message,ECode status) {
        this.message = message;
        this.statusCode = status;
    }

    // public MessageResponse(String message, ECode statusCode, Boolean status) {
    //     this.message = message;
    //     this.statusCode = statusCode;
    //     // this.status = status;
    // }

    // public MessageResponse(ECode statusCode,Object payload){
    //     this.statusCode  = statusCode;
    //     this.payload = payload;
    // }


    public ECode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(ECode statusCode) {
        this.statusCode = statusCode;
    }

    // public Boolean getStatus() {
    //     return status;
    // }

    // public void setStatus(Boolean status) {
    //     this.status = status;
    // }

    // public Object getPayload() {
    //     return payload;
    // }

    // public void setPayload(Object payload) {
    //     this.payload = payload;
    // }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
