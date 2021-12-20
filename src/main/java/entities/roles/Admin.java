package entities.roles;

import entities.types.Address;
import entities.Order;

public class Admin extends User {
    private Order[] orders;

    public Admin(String username, String password, String name, Address address, Order[] orders) {
        super(username, password, name, address);
        this.orders = orders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
