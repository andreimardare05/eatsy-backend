package com.example.eatsy.controller;

import com.example.eatsy.config.JwtUtils;
import com.example.eatsy.dto.RestaurantDto;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/add")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    public ResponseEntity add(@Valid @RequestBody RestaurantDto restaurantDto,
                              @RequestHeader (name="Authorization") String token) {
        return ResponseEntity.ok(this.restaurantService.add(restaurantDto));
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity getRestaurantById(@Valid @PathVariable long restaurantId) {
        return ResponseEntity.ok(this.restaurantService.getRestaurantById(restaurantId));
    }

    @DeleteMapping("/delete/{restaurantId}/user/{userId}")
    public ResponseEntity<String> deleteRestaurantById(@Valid @PathVariable long restaurantId,
                                                       long userId) {
        this.restaurantService.deleteRestaurantById(restaurantId, userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Restaurant deleted");
    }

    @GetMapping("/restaurants")
    public ResponseEntity getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

}
