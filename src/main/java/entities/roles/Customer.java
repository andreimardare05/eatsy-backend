package entities.roles;

import entities.types.Address;
import entities.Order;
import entities.types.OrderStatus;

public class Customer extends User {
    private Order currentOrder = null;

    public Customer(String username, String password, String name, Address address, Order currentOrder) {
        super(username, password, name, address);
        this.currentOrder = currentOrder;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void updateOrder(String identification, OrderStatus status) throws Exception {
        Order myOrder = getCurrentOrder();
        if (myOrder.getNumber() != identification) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(status);
    }
}
