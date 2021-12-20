package entities.roles;

import entities.types.Address;
import entities.Order;
import entities.types.OrderStatus;

import java.util.stream.Stream;

public class DeliveryPerson extends User {
    private Order currentOrder = null;
    private Address currentPosition =  new Address(0,0, "");

    public DeliveryPerson(String username, String password, String name, Address address) {
        super(username, password, name, address);
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public Address getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Address currentPosition) {
        this.currentPosition = currentPosition;
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
