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
        long userId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        return ResponseEntity.ok(this.restaurantService.add(restaurantDto, userId));
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    public ResponseEntity getRestaurantById(@RequestHeader (name="Authorization") String token) {
        long managerId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        return ResponseEntity.ok(this.restaurantService.getRestaurantByManagerId(managerId));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    public ResponseEntity<String> deleteRestaurant( @RequestHeader (name="Authorization") String token) {
        long managerId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        this.restaurantService.deleteRestaurantByManagerId(managerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Restaurant deleted");
    }


    @DeleteMapping("/delete/{restaurantId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteRestaurantById(@Valid @PathVariable long restaurantId) {
        this.restaurantService.deleteRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Restaurant deleted");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

}
