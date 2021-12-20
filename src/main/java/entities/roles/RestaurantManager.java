package entities.roles;

import entities.types.Address;
import entities.types.Restaurant;

public class RestaurantManager extends User {
    private Restaurant restaurant;

    public RestaurantManager(String username, String password, String name, Address address, Restaurant restaurant) {
        super(username, password, name, address);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
