package entities.roles;

import entities.types.Address;
import entities.types.OrderStatus;

public abstract class User {
    private String username;
    private String password;
    private String name;
    private Address address;

    public User(String username, String password, String name, Address address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    /**
     * Update state of the order from the object itself.
     * @param identification Identification string of the order.
     * @param status New status for the order.
     * @throws Exception In case identification string doesn't exist in the object.
     */
    public abstract void updateOrder(String identification, OrderStatus status) throws Exception;

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
