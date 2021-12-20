package entities.roles;

import entities.types.Address;
import entities.Order;

public class Customer extends User {
    private Order currentOrder;

    public Customer(String username, String password, String name, Address address, Order currentOrder) {
        super(username, password, name, address);
        this.currentOrder = currentOrder;
    }
}
