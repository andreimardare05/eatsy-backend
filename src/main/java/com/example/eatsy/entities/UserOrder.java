package com.example.eatsy.entities;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.DeliveryPerson;
import com.example.eatsy.entities.roles.User;
import com.example.eatsy.entities.types.*;
import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;
import com.example.eatsy.observer.models.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private DeliveryPerson deliveryPerson;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToOne
    private Payment payment;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_order_id")
    private List<UserOrderItem> userOrderItems;

}
