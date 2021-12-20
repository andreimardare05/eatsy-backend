package entities.roles;

import entities.types.Address;
import entities.Order;
import entities.types.OrderStatus;

public class User {
    private String username;
    private String password;
    private String name;
    private Address address;
    private Order order;

    public User(String username, String password, String name, Address address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public void updateOrder(OrderStatus status) {
        Order order = this.getOrder();
        order.setStatus(status);
        this.setOrder(order);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
