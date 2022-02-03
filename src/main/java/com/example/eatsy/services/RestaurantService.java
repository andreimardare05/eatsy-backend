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

    public Restaurant add(RestaurantDto restaurantDto, long user_id) {
        /*Optional<Restaurant> restaurantOptional = restaurantRepository.findByNameAndAddress();
        if (!restaurantOptional.isPresent()) {
            throw new RuntimeException("Restaurant not found!");
        }*/
        RestaurantManager restaurantManager = restaurantManagerRepository.findById(user_id).get();
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

    public Restaurant getRestaurantById(long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new RuntimeException("Restaurant not found!");
        }
        return restaurantOptional.get();
    }

    public void deleteRestaurantById(long id, long user_id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);

        if (!restaurantOptional.isPresent() ) {
            throw new RuntimeException("Restaurant not found!");
        }

        Optional<RestaurantManager> restaurantManagerOptional = restaurantManagerRepository.findById(user_id);
        if(restaurantManagerOptional.isPresent() && restaurantOptional.get().getId() != user_id) {
            throw new RuntimeException("User and the restaurant manager do not match!");
        }

        restaurantRepository.delete(restaurantOptional.get());
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
