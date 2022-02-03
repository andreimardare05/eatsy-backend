package com.example.eatsy.controller;

import com.example.eatsy.repositories.CustomerRepository;
import com.example.eatsy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class Customer {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }
}
