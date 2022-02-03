package com.example.eatsy.services;

import com.example.eatsy.config.JwtUtils;
import com.example.eatsy.dto.AddressDto;
import com.example.eatsy.dto.RestaurantDto;
import com.example.eatsy.entities.roles.RestaurantManager;
import com.example.eatsy.entities.roles.User;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.MenuItem;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.repositories.RestaurantManagerRepository;
import com.example.eatsy.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantManagerRepository restaurantManagerRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantManagerRepository restaurantManagerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantManagerRepository = restaurantManagerRepository;
    }

    public Restaurant add(RestaurantDto restaurantDto, long managerId) {
        Restaurant restaurantByManagerId = getRestaurantByManagerId(managerId);
        if(restaurantByManagerId != null) {
            throw new RuntimeException("Manager has restaurant");
        }
        RestaurantManager restaurantManager = restaurantManagerRepository.findById(managerId).get();
        AddressDto addressDto = restaurantDto.getAddress();
        Address address = new Address();
        if (addressDto != null) {
            address = Address.builder()
                    .longitude(restaurantDto.getAddress().getLongitude())
                    .latitude(restaurantDto.getAddress().getLatitude())
                    .address(restaurantDto.getAddress().getAddress())
                    .build();
        }
        List<MenuItem> menuItemsList = restaurantDto.getMenuItems().stream()
                .map(
                       item -> MenuItem.builder()
                               .description(item.getDescription())
                               .name(item.getName())
                               .price(item.getPrice())
                               .build()
                ).collect(Collectors.toList());
        Restaurant restaurant = Restaurant.builder()
                .name(restaurantDto.getName())
                .address(address)
                .contact(restaurantDto.getContact())
                .description(restaurantDto.getDescription())
                .openingTime(restaurantDto.getOpeningTime())
                .closingTime(restaurantDto.getClosingTime())
                .menuItemList(menuItemsList)
                .restaurantManager(restaurantManager)
                .build();

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        restaurantManager.setRestaurant(savedRestaurant);
        restaurantManagerRepository.save(restaurantManager);
        return savedRestaurant;
    }

    public Restaurant getRestaurantByManagerId(long id) {
        Restaurant restaurant = restaurantRepository.findByManagerId(id);
        return restaurant;
    }

    public void deleteRestaurantByManagerId(long id) {
        Restaurant restaurant = restaurantRepository.findByManagerId(id);
        restaurantRepository.delete(restaurant);
    }


    public void deleteRestaurantById(long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurantRepository.delete(restaurant.get());
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
