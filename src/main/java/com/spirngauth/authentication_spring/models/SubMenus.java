package com.spirngauth.authentication_spring.models;

import java.util.List;

public class SubMenus {
    private String name;
    private String url;
    private List<ERole> roles;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<ERole> getRoles() {
        return roles;
    }
    public void setRoles(List<ERole> roles) {
        this.roles = roles;
    }

    
}
