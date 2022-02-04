package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.RestaurantManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantManagerRepository extends UserRepository<RestaurantManager>{
    List<RestaurantManager> findAll();
}
