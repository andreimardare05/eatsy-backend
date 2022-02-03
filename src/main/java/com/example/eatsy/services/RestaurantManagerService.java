package com.example.eatsy.services;

import com.example.eatsy.entities.roles.DeliveryPerson;
import com.example.eatsy.entities.roles.RestaurantManager;
import com.example.eatsy.repositories.DeliveryRepository;
import com.example.eatsy.repositories.RestaurantManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantManagerService {

    @Autowired
    public RestaurantManagerRepository restaurantManagerRepository;

    public List<RestaurantManager> getAllRestaurantManagers() {
        return restaurantManagerRepository.findAll();
    }

    public void deleteRestaurantManagerById(long id) {
        Optional<RestaurantManager> restaurantManager = restaurantManagerRepository.findById(id);
        restaurantManagerRepository.delete(restaurantManager.get());
    }
}
