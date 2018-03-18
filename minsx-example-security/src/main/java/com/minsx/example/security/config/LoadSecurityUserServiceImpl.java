package com.minsx.example.security.config;

import com.minsx.example.security.entity.User;
import com.minsx.framework.security.core.*;
import com.minsx.framework.security.exception.AuthorizationException;
import com.minsx.framework.security.simple.SimpleCustomAuthority;
import com.minsx.framework.security.simple.SimpleRequestAuthority;
import com.minsx.framework.security.simple.SimpleRole;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadSecurityUserServiceImpl implements LoadSecurityUserService {

    @Override
    public SecurityUser loadUser(HttpServletRequest httpServletRequest) throws AuthorizationException {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEnabled(true);
        user.setLock(false);

        List<Role> roles = new ArrayList<>();
        roles.add(new SimpleRole("admin"));
        roles.add(new SimpleRole("user"));
        user.setRoles(roles);

        List<RequestAuthority> requestAuthorities = new ArrayList<>();
        requestAuthorities.add(new SimpleRequestAuthority("/user/userInfo","GET","ALL"));
        requestAuthorities.add(new SimpleRequestAuthority("/user/select","GET","ALL"));
        requestAuthorities.add(new SimpleRequestAuthority("/user/update","PUT","name=good&age=25"));
        user.setRequestAuthorities(requestAuthorities);

        List<CustomAuthority> customAuthorizes = new ArrayList<>();
        customAuthorizes.add(new SimpleCustomAuthority("user","good"));
        customAuthorizes.add(new SimpleCustomAuthority("user","john"));
        customAuthorizes.add(new SimpleCustomAuthority("user","joker"));
        customAuthorizes.add(new SimpleCustomAuthority("system","mack"));
        user.setCustomAuthorities(customAuthorizes);
        return user;
        //throw new AccessDenyException(403, "username or password is incorrect");
    }

}
