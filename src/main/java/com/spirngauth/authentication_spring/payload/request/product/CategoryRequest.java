package com.spirngauth.authentication_spring.payload.request.product;

public class CategoryRequest {
    private String name;
    private String desc;
    private Double discountPercent;
    private boolean active;
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
    public Double getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public CategoryRequest() {
    }
    @Override
    public String toString() {
        return "CategoryRequest [name=" + name + ", desc=" + desc + ", discountPercent=" + discountPercent + ", active="
                + active + "]";
    }

    
}
