package com.sadcodes.fitnesstrackerapp.controller;

import com.sadcodes.fitnesstrackerapp.dto.LoginRequest;
import com.sadcodes.fitnesstrackerapp.dto.LoginResponse;
import com.sadcodes.fitnesstrackerapp.dto.RegisterRequest;
import com.sadcodes.fitnesstrackerapp.dto.UserResponse;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import com.sadcodes.fitnesstrackerapp.security.JwtUtils;
import com.sadcodes.fitnesstrackerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest) {

        LoginResponse response = userService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
