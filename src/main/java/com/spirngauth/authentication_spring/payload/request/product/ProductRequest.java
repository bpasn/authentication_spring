package com.spirngauth.authentication_spring.payload.request.product;

import java.util.List;


public class ProductRequest{
    private String name;
    private String desc;
    private String SKU;

    private Double price;

    @Override
    public String toString() {
        return "ProductRequest [name=" + name + ", desc=" + desc + ", SKU=" + SKU + ", category="
                + ", price=" + price + "]";
    }

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

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String sKU) {
        SKU = sKU;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



   
    

    
    
    
    
}
