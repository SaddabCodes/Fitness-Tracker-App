package com.sadcodes.fitnesstrackerapp.controller;

import com.sadcodes.fitnesstrackerapp.dto.RegisterRequest;
import com.sadcodes.fitnesstrackerapp.dto.UserResponse;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }
}
