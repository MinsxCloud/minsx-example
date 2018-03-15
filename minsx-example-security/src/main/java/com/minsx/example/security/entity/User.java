package com.minsx.example.security.entity;


import com.minsx.framework.security.core.*;

import java.util.List;

public class User implements SecurityUser {

    private String username;

    private String password;

    private Boolean isLock;

    private Boolean isEnabled;

    private List<Role> roles;

    private List<CustomAuthorize> customAuthorizes;

    private List<RequestAuthorize> requestAuthorizes;


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Boolean isLocked() {
         return isLock;
    }

    @Override
    public Boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public List<Role> getRoles() {
        return this.roles;
    }

    @Override
    public List<CustomAuthorize> getCustomAuthorizes() {
        return this.customAuthorizes;
    }

    @Override
    public List<RequestAuthorize> getRequestAuthorizes() {
        return this.requestAuthorizes;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setCustomAuthorizes(List<CustomAuthorize> customAuthorizes) {
        this.customAuthorizes = customAuthorizes;
    }

    public void setRequestAuthorizes(List<RequestAuthorize> requestAuthorizes) {
        this.requestAuthorizes = requestAuthorizes;
    }
}
