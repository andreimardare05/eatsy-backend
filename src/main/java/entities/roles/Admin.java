package entities.roles;

import entities.OrderDetails;
import entities.types.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Admin extends User {
    private List<OrderDetails> orders = new ArrayList<>();

    public Admin(String username, String password, String name, Address address, List<OrderDetails> orders) {
        super(username, password, name, address);
        this.orders = orders;
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }

    @Override
    public void update(OrderDetails details) throws Exception {
        Stream<OrderDetails> myOrder = this.getOrders().stream().filter(order -> details.getNumber() == order.getNumber());
        myOrder.findFirst().get().setStatus(details.getStatus());
    }
}
