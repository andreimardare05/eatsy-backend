package com.example.eatsy.dto;

import com.example.eatsy.entities.roles.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Status userStatus;
    private String role;

}
