package com.example.eatsy.entities;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.DeliveryPerson;
import com.example.eatsy.entities.roles.User;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Payment;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Customer user;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private DeliveryPerson deliveryPerson;
    private OrderStatus status;
    @OneToOne
    private Payment payment;
    @OneToOne
    private Address address;

}
