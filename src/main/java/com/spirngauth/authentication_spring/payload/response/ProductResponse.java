package com.spirngauth.authentication_spring.payload.response;


public class ProductResponse extends BaseResponse {
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    
}
