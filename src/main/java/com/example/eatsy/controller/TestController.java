package com.example.eatsy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/costumer")
    @PreAuthorize("hasRole('COSTUMER') or hasRole('DELIVERY_MAN') or hasRole('ADMIN')")
    public String costumerAccess() {
        return "Costumer Content.";
    }

    @GetMapping("/restaurant_manager")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    public String restaurantAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}