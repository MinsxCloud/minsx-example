package com.minsx.example.security.config;

import com.minsx.example.security.entity.User;
import com.minsx.framework.security.base.SecurityUser;
import com.minsx.framework.security.core.LoadSecurityUserService;
import com.minsx.framework.security.exception.AuthorizationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoadSecurityUserServiceImpl implements LoadSecurityUserService {

    @Override
    public SecurityUser loadUser(HttpServletRequest httpServletRequest) throws AuthorizationException {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEnabled(true);
        user.setLock(false);
        return user;
        //throw new AccessDenyException(403, "username or password is incorrect");
    }

}
