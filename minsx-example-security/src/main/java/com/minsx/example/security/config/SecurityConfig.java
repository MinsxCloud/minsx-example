package com.minsx.example.security.config;

import com.minsx.framework.security.api.configure.WebSecurity;
import com.minsx.framework.security.api.configure.WebSecurityConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig implements WebSecurityConfigurer {

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
                .enabled(true)
                .authorizeConfigurer()
                    .needAuthorize("/**")
                    .unNeedAuthorize("/", "/static/**")
                .and()
                    .loginConfigurer()
                    .loginAPIUrl("/api/login")
                    .loginPageUrl("/page/login")
                .and()
                    .logoutConfigurer()
                    .logoutAPIUrl("/api/logout");
    }


}
