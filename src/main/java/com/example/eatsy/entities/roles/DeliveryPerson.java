package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.UserOrder;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name = "delivery_id")
@DiscriminatorValue("delivery")
@Entity
@SuperBuilder
public class DeliveryPerson extends User {
    @OneToMany
    @JoinTable(name= "delivery_orders")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserOrder> orders;
    @OneToOne
    private Address currentPosition;
   /* @Builder
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
    }*/
}
