package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.RestaurantManager;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantManagerRepository extends UserRepository<RestaurantManager>{
}
