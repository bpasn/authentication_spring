package com.spirngauth.authentication_spring.models;

import java.util.Date;

public class ErrorDetail {
    private Date timesstame;
    private String message;
    private String details;

    public ErrorDetail() {
    }

    public ErrorDetail(Date timesstame, String message, String details){
        this.timesstame = timesstame;
        this.message = message;
        this.details = details;

    }

    public Date getTimesstame() {
        return timesstame;
    }

    public void setTimesstame(Date timesstame) {
        this.timesstame = timesstame;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
