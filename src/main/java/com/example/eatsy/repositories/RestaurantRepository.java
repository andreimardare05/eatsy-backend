package com.example.eatsy.repositories;

import com.example.eatsy.entities.types.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Query("select e from Restaurant e where e.restaurantManager.id = :id")
    Restaurant findByManagerId(long id);
    List<Restaurant> findAll();
}
