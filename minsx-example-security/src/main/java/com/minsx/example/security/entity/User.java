package com.minsx.example.security.entity;


import com.minsx.framework.security.base.Authorize;
import com.minsx.framework.security.base.SecurityUser;

import java.util.List;

public class User implements SecurityUser {

    private String username;

    private String password;

    private Boolean isLock;

    private Boolean isEnabled;

    private List<Authorize> authorities;

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
        return this.isLock;
    }

    @Override
    public Boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public List<Authorize> getAuthorities() {
        return this.authorities;
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

    public void setAuthorities(List<Authorize> authorities) {
        this.authorities = authorities;
    }
}
