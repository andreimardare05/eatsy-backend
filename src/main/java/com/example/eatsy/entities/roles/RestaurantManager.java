package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.Order;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/*
@Getter
@AllArgsConstructor
public class RestaurantManager extends User {
    private Restaurant restaurant;
    private List<Order> orders = new ArrayList<>();
    @Builder
    public RestaurantManager(String username, String password, String name, String email, String phone, Restaurant restaurant) {
        super(username, password, name, email, phone);
        this.restaurant = restaurant;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void updateOrder(String identification, OrderStatus status) {
        Stream<Order> myOrder = this.getOrders().stream().filter(order -> identification == order.getNumber());
        myOrder.findFirst().get().setStatus(status);
    }
}
*/