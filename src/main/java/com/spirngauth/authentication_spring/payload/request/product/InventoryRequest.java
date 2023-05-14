package com.spirngauth.authentication_spring.payload.request.product;

public class InventoryRequest {
    private int quantity;


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryRequest(int quantity) {
        this.quantity = quantity;
    }

    public InventoryRequest() {
    }
    
    
}
