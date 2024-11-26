package com.sonypiay.security.security_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting(HttpServletRequest request) {
        return "Welcome to Spring Boot Application. Your Session ID: " + request.getSession().getId();
    }
}
