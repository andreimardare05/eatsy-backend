package entities.roles;

import entities.OrderDetails;
import entities.types.Address;

public class Customer extends User {
    private OrderDetails currentOrder = null;

    public Customer(String username, String password, String name, Address address, OrderDetails currentOrder) {
        super(username, password, name, address);
        this.currentOrder = currentOrder;
    }

    public OrderDetails getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(OrderDetails currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void update(OrderDetails details) throws Exception {
        OrderDetails myOrder = getCurrentOrder();
        if (myOrder.getNumber() != myOrder.getNumber()) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(myOrder.getStatus());
    }
}
