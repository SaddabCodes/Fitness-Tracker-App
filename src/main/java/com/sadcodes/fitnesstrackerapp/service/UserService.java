package com.sadcodes.fitnesstrackerapp.service;

import com.sadcodes.fitnesstrackerapp.dto.LoginRequest;
import com.sadcodes.fitnesstrackerapp.dto.LoginResponse;
import com.sadcodes.fitnesstrackerapp.dto.RegisterRequest;
import com.sadcodes.fitnesstrackerapp.dto.UserResponse;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.model.UserRole;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import com.sadcodes.fitnesstrackerapp.security.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public UserResponse register(RegisterRequest req) {
        UserRole role = req.getRole()!=null ? req.getRole():UserRole.USER;
        User user = User.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(role)
                .build();

        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    public LoginResponse login(LoginRequest req) {

        User user = userRepository.findByEmail(req.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));;
        if (user == null ||
                !passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtils.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new LoginResponse(token, mapToResponse(user));
    }

    private UserResponse mapToResponse(User user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setEmail(user.getEmail());
        res.setCreatedAt(user.getCreatedAt());
        res.setUpdatedAt(user.getUpdatedAt());
        return res;
    }
}
