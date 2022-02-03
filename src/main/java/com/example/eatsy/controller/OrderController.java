package com.example.eatsy.controller;

import com.example.eatsy.dto.RestaurantDto;
import com.example.eatsy.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*@PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody RestaurantDto restaurantDto,
                              @RequestHeader (name="Authorization") String token) {
        long userId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        return ResponseEntity.ok(this.restaurantService.add(restaurantDto, userId));
    }*/
}
