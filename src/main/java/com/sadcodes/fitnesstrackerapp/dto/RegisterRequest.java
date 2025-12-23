package com.sadcodes.fitnesstrackerapp.dto;

import com.sadcodes.fitnesstrackerapp.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private UserRole role;
}
