package com.flagcamp.tripadvisor.controller;

import com.flagcamp.tripadvisor.model.User;
import com.flagcamp.tripadvisor.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public void addUser(@RequestBody User user) {
        registerService.add(user);
    }
}
