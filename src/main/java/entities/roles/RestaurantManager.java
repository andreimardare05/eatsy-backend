package entities.roles;

import entities.OrderDetails;
import entities.types.Address;
import entities.types.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RestaurantManager extends User {
    private Restaurant restaurant;
    private List<OrderDetails> orders = new ArrayList<>();

    public RestaurantManager(String username, String password, String name, Address address, Restaurant restaurant, List<OrderDetails> orders) {
        super(username, password, name, address);
        this.restaurant = restaurant;
        this.orders = orders;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }

    @Override
    public void update(OrderDetails details) {
        Stream<OrderDetails> myOrder = this.getOrders().stream().filter(order -> details.getNumber() == order.getNumber());
        myOrder.findFirst().get().setStatus(details.getStatus());
    }
}
