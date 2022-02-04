package com.example.eatsy.controller;

import com.example.eatsy.config.JwtUtils;
import com.example.eatsy.dto.UserDto;
import com.example.eatsy.dto.UserOrderDto;
import com.example.eatsy.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/add")
    public ResponseEntity save(@RequestBody UserOrderDto userOrderDto) {
       // long userId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        return ResponseEntity.ok(this.userOrderService.save(userOrderDto));
    }

    @GetMapping("/restaurant/{resturantId}")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('DELIVERY_MAN') or hasRole('ADMIN')")
    public ResponseEntity getRestaurantOrders(@PathVariable long resturantId) {
        // long userId = Long.parseLong(jwtUtils.getIdFromJwtToken(token.split(" ")[1]));
        return ResponseEntity.ok(this.userOrderService.getRestaurantOrders(resturantId));
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('DELIVERY_MAN') or hasRole('ADMIN')")
    public ResponseEntity editOrder(@RequestBody UserOrderDto userOrderDto) {
        return ResponseEntity.ok(this.userOrderService.updateUserOrder(userOrderDto));
    }
}
