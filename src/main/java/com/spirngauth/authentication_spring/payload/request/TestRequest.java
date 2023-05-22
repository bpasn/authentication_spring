package com.spirngauth.authentication_spring.payload.request;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestRequest {
    private String attributeSet;
    private String productType;
    private List<File> files;
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
    public List<File> getFiles() {
        return files;
    }
    public void setFiles(List<File> files) {
        this.files = files;
    }
    @Override
    public String toString() {
        return "TestRequest [attributeSet=" + attributeSet + ", productType=" + productType + ", files=" + files + "]";
    }
    
    
    

    
    

    
}
