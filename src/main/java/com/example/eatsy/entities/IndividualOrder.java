package com.example.eatsy.entities;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.DeliveryPerson;
import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import com.example.eatsy.entities.types.Payment;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;

import java.util.List;

public class IndividualOrder extends UserOrder {
    private String allergens;

}
