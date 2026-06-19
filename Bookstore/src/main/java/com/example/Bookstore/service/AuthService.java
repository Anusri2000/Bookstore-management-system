package com.example.Bookstore.service;

import com.example.Bookstore.dto.AuthResponse;
import com.example.Bookstore.dto.LoginRequest;
import com.example.Bookstore.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}