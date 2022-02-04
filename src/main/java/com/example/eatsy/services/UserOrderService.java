package com.example.eatsy.services;

import com.example.eatsy.dto.AddressDto;
import com.example.eatsy.dto.UserOrderDto;
import com.example.eatsy.entities.UserOrder;
import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.User;
import com.example.eatsy.entities.types.*;
import com.example.eatsy.repositories.CustomerRepository;
import com.example.eatsy.repositories.MenuItemRepository;
import com.example.eatsy.repositories.RestaurantRepository;
import com.example.eatsy.repositories.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public UserOrder save(UserOrderDto userOrderDto) {
        Customer customer = customerRepository.findById(userOrderDto.getUserId()).get();
        Restaurant restaurant = restaurantRepository.findById(userOrderDto.getRestaurantId())
                .get();
        AddressDto addressDto = userOrderDto.getAddress();
        Address address = new Address();
        if (addressDto != null) {
            address = Address.builder()
                    .longitude(userOrderDto.getAddress().getLongitude())
                    .latitude(userOrderDto.getAddress().getLatitude())
                    .address(userOrderDto.getAddress().getAddress())
                    .build();
        }
        List<UserOrderItem> userOrderItems = userOrderDto.getOrderItems().stream()
                .map(
                        item -> {

                            MenuItem menuItem = menuItemRepository.getMenuItem(item.getName(), restaurant.getId());
                                return UserOrderItem.builder()
                                        .menuItemId(menuItem.getId())
                                        .quantity(item.getQuantity())
                                        .build();
                        }
                ).collect(Collectors.toList());

        UserOrder savedOrder = UserOrder.builder()
                .address(address)
                .customer(customer)
                .userOrderItems(userOrderItems)
                .restaurant(restaurant)
                .status(OrderStatus.PENDING)
                .total(userOrderDto.getTotal())
                .build();

        userOrderRepository.save(savedOrder);

        return userOrderRepository.save(savedOrder);
    }

    public List<UserOrder> getRestaurantOrders(long restaurantId) {
        return userOrderRepository.findAllByRestaurant(restaurantId);
    }

    public UserOrder updateUserOrder(UserOrderDto userOrderDto) {
        Optional<UserOrder> orderFound = userOrderRepository.findById(userOrderDto.getId());
        if (!orderFound.isPresent())
            throw new RuntimeException("Order not found");

        UserOrder updatedUserOrder = orderFound.get();
        updatedUserOrder.setStatus(userOrderDto.getStatus());
        return userOrderRepository.save(updatedUserOrder);
    }
}
