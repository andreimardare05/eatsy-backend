package com.example.eatsy.controller;

import com.example.eatsy.dto.SignupRequest;
import com.example.eatsy.dto.UserDto;
import com.example.eatsy.repositories.UserRepository;
import com.example.eatsy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteUserById(@Valid @PathVariable long userId) {
        this.userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity editUserById(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userService.updateUser(userDto));
    }

}
