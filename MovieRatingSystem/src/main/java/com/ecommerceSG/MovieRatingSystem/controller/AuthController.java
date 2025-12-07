package com.ecommerceSG.MovieRatingSystem.controller;

import com.ecommerceSG.MovieRatingSystem.model.User;
import com.ecommerceSG.MovieRatingSystem.repository.UserRepository;
import com.ecommerceSG.MovieRatingSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> req) {
        return service.login(req.get("username"), req.get("password"));
    }
}