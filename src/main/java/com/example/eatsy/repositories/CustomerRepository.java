package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.RestaurantManager;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends UserRepository<Customer>{

}
