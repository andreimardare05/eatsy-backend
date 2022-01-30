package com.example.eatsy.dto;

import com.example.eatsy.entities.roles.User;
import lombok.Getter;

@Getter
public class UserDto {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;

    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        //user.setPhone(phone);
        //user.setName(name);
        return user;
    }
}