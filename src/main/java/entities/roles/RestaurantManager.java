package entities.roles;

import entities.Order;
import entities.types.Address;
import entities.types.OrderStatus;
import entities.types.Restaurant;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
public class RestaurantManager extends User {
    private Restaurant restaurant;
    private List<Order> orders = new ArrayList<>();

    @Builder
    public RestaurantManager(String username, String password, String name, Address address, Restaurant restaurant) {
        super(username, password, name, address);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void updateOrder(String identification, OrderStatus status) {
        Stream<Order> myOrder = this.getOrders().stream().filter(order -> identification == order.getNumber());
        myOrder.findFirst().get().setStatus(status);
    }
}
