package com.minsx.example.security.initial;

import com.alibaba.fastjson.JSON;
import com.minsx.framework.security.configurer.WebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialApp implements CommandLineRunner {

    @Autowired
    WebSecurity webSecurity;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(JSON.toJSONString(webSecurity));
    }

}
