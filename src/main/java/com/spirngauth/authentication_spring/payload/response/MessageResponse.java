package com.spirngauth.authentication_spring.payload.response;

import com.spirngauth.authentication_spring.models.ECode;

public class MessageResponse {
    private String message;
    private ECode status;
    private Number code = 200;
    // private Object payload;


    

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }

    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }
    public MessageResponse(String message,ECode status,Number code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
    public MessageResponse(String message,ECode status) {
        this.message = message;
        this.status = status;
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
        return status;
    }

    public void setStatusCode(ECode statusCode) {
        this.status = statusCode;
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
