package com.example.eatsy.dto;

import com.example.eatsy.entities.roles.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JwtResponse {
    private String token;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Status status;
    private String role;
}