package com.example.eatsy.observer;


import com.example.eatsy.entities.types.OrderStatus;

public class OrderDetails {
    private String number;
    private String comment;
    private OrderStatus status;

    public OrderDetails(String number, String comment, OrderStatus status) {
        this.number = number;
        this.comment = comment;
        this.status = status;
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
