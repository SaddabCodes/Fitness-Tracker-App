package com.sadcodes.fitnesstrackerapp.service;

import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}
