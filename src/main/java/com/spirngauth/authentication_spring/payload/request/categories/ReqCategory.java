package com.spirngauth.authentication_spring.payload.request.categories;
import org.springframework.web.multipart.MultipartFile;


public class ReqCategory {
    private String categoryName;
    private String categoryDescription;
    private String icon;
    private MultipartFile imagePath;
    private Boolean active;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MultipartFile getImagePath() {
        return imagePath;
    }

    public void setImagePath(MultipartFile imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
