package entities.roles;

import entities.OrderDetails;
import entities.types.Address;

public class DeliveryPerson extends User {
    private OrderDetails currentOrder = null;
    private Address currentPosition =  new Address(0,0, "");

    public DeliveryPerson(String username, String password, String name, Address address, OrderDetails currentOrder, Address currentPosition) {
        super(username, password, name, address);
        this.currentOrder = currentOrder;
        this.currentPosition = currentPosition;
    }

    public OrderDetails getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(OrderDetails currentOrder) {
        this.currentOrder = currentOrder;
    }

    public Address getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Address currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public void update(OrderDetails details) throws Exception {
        OrderDetails myOrder = getCurrentOrder();
        if (myOrder.getNumber() != details.getNumber()) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(details.getStatus());
    }
}
