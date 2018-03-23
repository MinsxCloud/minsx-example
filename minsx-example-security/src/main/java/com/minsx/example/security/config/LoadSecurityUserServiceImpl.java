package com.minsx.example.security.config;

import com.minsx.example.security.entity.User;
import com.minsx.framework.security.api.authority.CustomAuthority;
import com.minsx.framework.security.api.authority.RequestAuthority;
import com.minsx.framework.security.api.basic.Role;
import com.minsx.framework.security.api.basic.SecurityUser;
import com.minsx.framework.security.api.exception.AuthorityDenyException;
import com.minsx.framework.security.api.exception.AuthorizationException;
import com.minsx.framework.security.api.service.LoadSecurityUserService;
import com.minsx.framework.security.api.simple.SimpleCustomAuthority;
import com.minsx.framework.security.api.simple.SimpleRequestAuthority;
import com.minsx.framework.security.api.simple.SimpleRole;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadSecurityUserServiceImpl implements LoadSecurityUserService {

    @Override
    public SecurityUser loadUser(HttpServletRequest httpServletRequest) throws AuthorizationException {
        User user = new User();
        user.setUsername(httpServletRequest.getParameter("username"));
        user.setPassword(httpServletRequest.getParameter("password"));
        user.setEnabled(true);
        user.setLock(false);

        List<Role> roles = new ArrayList<>();
        roles.add(new SimpleRole("admin"));
        roles.add(new SimpleRole("user"));
        user.setRoles(roles);

        List<RequestAuthority> requestAuthorities = new ArrayList<>();
        requestAuthorities.add(new SimpleRequestAuthority("/user/userInfo", "GET", "ALL"));
        requestAuthorities.add(new SimpleRequestAuthority("/user/select", "GET", "ALL"));
        requestAuthorities.add(new SimpleRequestAuthority("/user/deleteUser", "DELETE", "ALL"));
        requestAuthorities.add(new SimpleRequestAuthority("/user/update", "PUT", "name=good&age=25"));
        user.setRequestAuthorities(requestAuthorities);

        List<CustomAuthority> customAuthorizes = new ArrayList<>();
        customAuthorizes.add(new SimpleCustomAuthority("user", "good"));
        customAuthorizes.add(new SimpleCustomAuthority("user", "john"));
        customAuthorizes.add(new SimpleCustomAuthority("user", "joker"));
        customAuthorizes.add(new SimpleCustomAuthority("system", "mack"));
        user.setCustomAuthorities(customAuthorizes);

        if (!("admin".equals(user.getUsername()) && "admin".equals(user.getPassword()))) {
            throw new AuthorityDenyException(403, "username or password is incorrect");
        }
        return user;
    }

}
