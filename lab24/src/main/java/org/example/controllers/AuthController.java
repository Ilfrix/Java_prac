package org.example.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.services.UserService;
import org.example.entities.User;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
    private UserService service;

    @PostMapping("/registration")
    public void createUser(@RequestBody User user) {
        System.out.println("start");
        service.createUser(user);
        System.out.println(user.name);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return "Login successful";
    }
}
