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
        long user_id = restaurantDto.getManager();
        //long user_id = jwtUtils.getIdFromJwtToken(token);
        System.out.println("here"+user_id);
        return ResponseEntity.ok(this.restaurantService.add(restaurantDto, user_id));
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity getRestaurantById(@Valid @PathVariable long restaurantId) {
        return ResponseEntity.ok(this.restaurantService.getRestaurantById(restaurantId));
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<String> deleteRestaurantById(@Valid @PathVariable long restaurantId,
                                                       @RequestHeader (name="Authorization") String token) {
        long user_id = jwtUtils.getIdFromJwtToken(token);
        this.restaurantService.deleteRestaurantById(restaurantId, user_id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Restaurant deleted");
    }

    @GetMapping("/restaurants")
    public ResponseEntity getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

}
