package com.example.Bookstore.controller;

import com.example.Bookstore.dto.AuthResponse;
import com.example.Bookstore.dto.LoginRequest;
import com.example.Bookstore.dto.RegisterRequest;
import com.example.Bookstore.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    // Constructor Injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request
    ) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }
}