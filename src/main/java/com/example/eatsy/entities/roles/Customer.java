package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.Order;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Payment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Customer extends User {
    private final Order currentOrder;
    private final Payment payment;


    @Builder
    public Customer(String username, String password, String name, Address address, Order currentOrder, Payment payment) {
        this.currentOrder = currentOrder;
        this.payment = payment;
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
