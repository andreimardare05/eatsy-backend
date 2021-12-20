package entities;

import entities.types.OrderStatus;

public class IndividualOrder extends Order {
    public IndividualOrder(String number, String comment, OrderStatus details) {
        super(number, comment, details);
    }
}
