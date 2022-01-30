package com.example.eatsy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class SignupRequest {
    private String fistName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String role;
}
