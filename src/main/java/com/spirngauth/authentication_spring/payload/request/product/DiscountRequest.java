package com.spirngauth.authentication_spring.payload.request.product;

public class DiscountRequest {
    private String name;
    private String desc;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public DiscountRequest() {
    }

    
}
