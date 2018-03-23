package com.minsx.example.security.config;

import com.alibaba.fastjson.JSON;
import com.minsx.framework.security.api.listener.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessEventListener implements ApplicationListener<LoginSuccessEvent>{

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println(JSON.toJSONString(event.getAuthentication()));
    }

}
