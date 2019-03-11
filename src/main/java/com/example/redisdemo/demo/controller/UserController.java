package com.example.redisdemo.demo.controller;

import com.example.redisdemo.demo.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getUser")
    public String getUser() {
        return userService.getUser(001);
    }
}
