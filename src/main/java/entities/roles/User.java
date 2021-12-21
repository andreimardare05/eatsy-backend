package entities.roles;

import entities.models.Observer;
import entities.OrderDetails;
import entities.types.Address;

public abstract class User implements Observer {
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
     * @param details New details for the order (new status).
     * @throws Exception In case identification string doesn't exist in the object.
     */
    public abstract void update(OrderDetails details) throws Exception;

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
