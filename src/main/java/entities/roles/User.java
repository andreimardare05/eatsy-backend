package entities.roles;

import entities.types.Address;
import entities.types.OrderStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class User {
    private final String username;
    private final String password;
    private String name;
    private Address address;

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.name = builder.name;
        this.address = builder.address;
    }

    /**
     * Update state of the order from the object itself.
     * @param identification Identification string of the order.
     * @param status New status for the order.
     * @throws Exception In case identification string doesn't exist in the object.
     */
    public abstract void updateOrder(String identification, OrderStatus status) throws Exception;

    /*public String getUsername() {
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
*/
    // this is just a sketch
    public static class UserBuilder
    {
        private final String username;
        private final String password;
        private String name;
        private Address address;

        public UserBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }
    }
}
