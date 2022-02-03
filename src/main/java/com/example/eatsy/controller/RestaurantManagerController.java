package com.example.eatsy.controller;

import com.example.eatsy.repositories.RestaurantManagerRepository;
import com.example.eatsy.services.RestaurantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/manager")
public class RestaurantManagerController {

    @Autowired
    private RestaurantManagerService restaurantManagerService;

    @GetMapping("/all")
    public ResponseEntity getAllRestaurantManager() {
        return ResponseEntity.ok(this.restaurantManagerService.getAllRestaurantManagers());
    }

    @DeleteMapping("/delete/{managerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteRestaurantManagerById(@Valid @PathVariable long managerId) {
        this.restaurantManagerService.deleteRestaurantManagerById(managerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Manager deleted");
    }
}
