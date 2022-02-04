package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.UserOrder;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
//@PrimaryKeyJoinColumn(name = "customer_id")
@DiscriminatorValue("customer")
@Entity
@SuperBuilder
@NoArgsConstructor
public class Customer extends User {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "customer_orders")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserOrder> orderList;

/*
    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void updateOrder(String identification, OrderStatus status) throws Exception {
        Order myOrder = getCurrentOrder();
        if (myOrder.getNumber() != identification) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(status);
    }*/
}
