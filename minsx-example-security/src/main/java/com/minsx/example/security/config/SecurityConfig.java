package com.minsx.example.security.config;

import com.minsx.framework.security.configurer.WebSecurity;
import com.minsx.framework.security.configurer.WebSecurityConfigurer;
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
                .loginPageUrl("/user/login")
                .loginFailureUrl("/login")
                .loginSuccessUrl("/user")
                .and()
                .logoutConfigurer()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/");
    }


}
