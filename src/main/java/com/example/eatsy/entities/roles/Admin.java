package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.Order;
import com.example.eatsy.entities.types.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor

public class Admin extends User {
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Admin(String username, String password, String name, Address address, List<Order> orders) {
        //super(username, password, name, address);
        this.orders = orders;
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
