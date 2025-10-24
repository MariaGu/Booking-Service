package org.example.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {
    public String username;
    public String password;
    public String email;
}
