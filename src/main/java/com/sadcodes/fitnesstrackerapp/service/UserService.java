package com.sadcodes.fitnesstrackerapp.service;

import com.sadcodes.fitnesstrackerapp.dto.RegisterRequest;
import com.sadcodes.fitnesstrackerapp.dto.UserResponse;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(RegisterRequest registerRequest) {
        User user = new User(
                null,
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getPassword(),
                registerRequest.getEmail(),
                Instant.parse("2025-12-08T14:49:07.208Z")
                        .atZone(ZoneOffset.UTC)
                        .toLocalDateTime(),
                Instant.parse("2025-12-08T14:49:07.208Z")
                        .atZone(ZoneOffset.UTC)
                        .toLocalDateTime()
                , List.of(),
                List.of()
        );


        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }
}
