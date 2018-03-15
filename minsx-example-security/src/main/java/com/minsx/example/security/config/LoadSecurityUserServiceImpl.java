package com.minsx.example.security.config;

import com.minsx.example.security.entity.User;
import com.minsx.framework.security.core.LoadSecurityUserService;
import com.minsx.framework.security.core.RequestAuthorize;
import com.minsx.framework.security.core.SecurityUser;
import com.minsx.framework.security.exception.AuthorizationException;
import com.minsx.framework.security.simple.SimpleRequestAuthorize;
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
        List<RequestAuthorize> authorizes = new ArrayList<>();
        authorizes.add(new SimpleRequestAuthorize("/user/userInfo","GET",""));
        authorizes.add(new SimpleRequestAuthorize("USER","delete",""));
        authorizes.add(new SimpleRequestAuthorize("USER","update",""));
        user.setRequestAuthorizes(authorizes);
        return user;
        //throw new AccessDenyException(403, "username or password is incorrect");
    }

}
