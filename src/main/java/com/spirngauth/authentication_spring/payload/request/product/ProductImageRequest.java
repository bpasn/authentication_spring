package com.spirngauth.authentication_spring.payload.request.product;

public class ProductImageRequest {
    private String[] images;
    private String attibuteSet;
    private String productType;
    public String[] getImages() {
        return images;
    }
    public void setImages(String[] images) {
        this.images = images;
    }
    public String getAttibuteSet() {
        return attibuteSet;
    }
    public void setAttibuteSet(String attibuteSet) {
        this.attibuteSet = attibuteSet;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
   
    
}
