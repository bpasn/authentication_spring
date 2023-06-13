package com.spirngauth.authentication_spring.payload.response;

import java.util.Map;

public class ResponseMessage {
    private boolean success;
    private Map<String, String> payload;
    public ResponseMessage(boolean success, Map<String,String> payload) {
        this.success = success;
        this.payload = payload;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Map<String, String> getPayload() {
        return payload;
    }
    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    
    
}
