package com.minsx.example.security.controller;

import com.minsx.framework.security.annotation.Authority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class SystemController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/userInfo")
    @Authority({"admin", "user"})
    public ResponseEntity<?> getUserInfo() {
        return new ResponseEntity<Object>("username:good", HttpStatus.OK);
    }

}
