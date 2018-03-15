package com.minsx.example.security.controller;

import com.minsx.framework.security.annotation.Authority;
import com.minsx.framework.security.annotation.Logic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class SystemController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/userInfo")
    @ResponseBody
    @Authority(value = {"user:good", "system:mack"}, logic = Logic.AND)
    public ResponseEntity<?> getUserInfo() {
        return new ResponseEntity<Object>("username:good", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestParam String name, @RequestParam Integer age) {
        return new ResponseEntity<Object>("update success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    @Authority({"admin", "user"})
    public ResponseEntity<?> deleteUser() {
        return new ResponseEntity<Object>("username:good", HttpStatus.OK);
    }

}
