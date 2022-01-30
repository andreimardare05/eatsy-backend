package com.example.eatsy.entities;

import com.example.eatsy.entities.roles.User;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String number;
    private String comment;
    private OrderStatus status;
    private List<User> usersInvolved = new ArrayList<>();

    public Order(String number, String comment, OrderStatus status) {
        this.number = number;
        this.comment = comment;
        this.status = status;
    }

    public Order(OrderDetails details, List<Observer> usersInvolved) {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
