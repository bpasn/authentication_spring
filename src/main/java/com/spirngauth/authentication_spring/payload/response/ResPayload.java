package com.spirngauth.authentication_spring.payload.response;

import java.util.HashMap;

public class ResPayload  {
    private Boolean success;
    private Object payload = new HashMap<>();
    
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

   
}
