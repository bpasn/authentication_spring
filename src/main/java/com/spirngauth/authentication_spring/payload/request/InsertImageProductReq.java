package com.spirngauth.authentication_spring.payload.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class InsertImageProductReq {
    private String id = null;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "InsertImageProductReq [id=" + id + ", attributeSet=" + attributeSet + ", productType=" + productType
                + ", files=" + Arrays.toString(files) + "]";
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}
