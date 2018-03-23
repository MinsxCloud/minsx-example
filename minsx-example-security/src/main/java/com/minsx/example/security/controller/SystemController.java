package com.minsx.example.security.controller;

import com.alibaba.fastjson.JSON;
import com.minsx.framework.security.api.annotation.*;
import com.minsx.framework.security.api.token.UserToken;
import com.minsx.framework.security.api.token.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class SystemController {

    @Autowired
    UserTokenManager userTokenManager;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/userInfo")
    @ResponseBody
    @VerifyAuthority(value = {"user:good", "system:mack", "group:jack"}, logic = Logic.OR)
    //@VerifyRole(value = {"admin", "user", "super"}, logic = Logic.AND, order = Order.BEFORE, scope = Scope.EXCLUDE)
    //@VerifyExpression(value = {"'good'==#name"},script = Script.SPEL)
    public ResponseEntity<?> getUserInfo(@RequestParam String name) {
        List<UserToken> userTokens = userTokenManager.getUserTokensByUsername("admin");
        System.out.println(JSON.toJSONString(userTokens));
        return new ResponseEntity<Object>("username:good", HttpStatus.OK);
    }

    @GetMapping(value = "/select")
    public ResponseEntity<?> selectUser() {
        return new ResponseEntity<Object>("select success", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestParam String name, @RequestParam Integer age) {
        return new ResponseEntity<Object>("update success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    @VerifyAuthority({"admin", "user"})
    public ResponseEntity<?> deleteUser() {
        return new ResponseEntity<Object>("username:good", HttpStatus.OK);
    }

}
