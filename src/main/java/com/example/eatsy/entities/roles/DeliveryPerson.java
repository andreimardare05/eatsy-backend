package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.Order;
import com.example.eatsy.entities.types.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
/*
@Getter
@AllArgsConstructor
public class DeliveryPerson extends User {
    private Order currentOrder = null;
    private Address currentPosition =  new Address(0,0, "");
    @Builder
    public DeliveryPerson(String username, String password, String name, String email, String phone, Order currentOrder, Address currentPosition) {
        super(username, password, name, email, phone);
        this.currentPosition = currentPosition;
        this.currentOrder = currentOrder;
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }
    public void updateOrder(String identification, OrderStatus status) throws Exception {
        Order myOrder = getCurrentOrder();
        if (myOrder.getNumber() != identification) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(status);
    }
}
*/