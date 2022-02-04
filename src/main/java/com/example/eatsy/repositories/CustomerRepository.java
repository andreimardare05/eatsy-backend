package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.RestaurantManager;
import com.example.eatsy.entities.roles.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends UserRepository<Customer>{
    List<Customer> findAll();
}
