package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Restaurant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@DiscriminatorValue("manager")
//@PrimaryKeyJoinColumn(name = "manager_id")
@SuperBuilder
public class RestaurantManager extends User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name= "restaurant_managers")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Restaurant restaurant;


    /*
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
    }*/
}
