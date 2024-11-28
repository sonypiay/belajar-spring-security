package com.sonypiay.security.security_demo.controller;

import com.sonypiay.security.security_demo.model.Users;
import com.sonypiay.security.security_demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return usersService.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users) {
        return usersService.verify(users);
    }
}
