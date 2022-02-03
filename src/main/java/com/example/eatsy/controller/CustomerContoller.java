package com.example.eatsy.controller;

import com.example.eatsy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerContoller {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @DeleteMapping("/delete/{costumerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteCostumerById(@Valid @PathVariable long customerId) {
        this.customerService.deleteCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

}
