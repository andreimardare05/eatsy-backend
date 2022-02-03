package com.example.eatsy.controller;

import com.example.eatsy.services.CustomerService;
import com.example.eatsy.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/all")
    public ResponseEntity getAllDelivery() {
        return ResponseEntity.ok(this.deliveryService.getAllDelivery());
    }

    @DeleteMapping("/delete/{deliveryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteDeliveryManById(@Valid @PathVariable long deliveryId) {
        this.deliveryService.deleteDeliveryManById(deliveryId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }
}