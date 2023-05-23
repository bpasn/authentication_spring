package com.spirngauth.authentication_spring.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class TestRequest {
    private String attributeSet;
    private String productType;
    private MultipartFile[] files;
    public String getAttributeSet() {
        return attributeSet;
    }
    public void setAttributeSet(String attributeSet) {
        this.attributeSet = attributeSet;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "TestRequest [attributeSet=" + attributeSet + ", productType=" + productType + "]";
    }
    public MultipartFile[] getFiles() {
        return files;
    }
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
    
    
    
    
    

    
    

    
}
