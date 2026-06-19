package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.AuthResponse;
import com.example.Bookstore.dto.LoginRequest;
import com.example.Bookstore.dto.RegisterRequest;
import com.example.Bookstore.enums.Role;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.security.JwtUtil;
import com.example.Bookstore.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // Constructor Injection
    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole(Role.CUSTOMER);

        userRepository.save(user);

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user =
                userRepository.findByEmail(
                        request.getEmail()
                ).orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        )
                );

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        String token =
                jwtUtil.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(token);
    }
}