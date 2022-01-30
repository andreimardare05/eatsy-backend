package com.example.eatsy.entities;

import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;

import java.util.List;

public class IndividualOrder extends Order {
    private String allergens;

    public IndividualOrder(OrderDetails details, List<Observer> usersInvolved, String allergens) {
        super(details, usersInvolved);
        this.allergens = allergens;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

}
