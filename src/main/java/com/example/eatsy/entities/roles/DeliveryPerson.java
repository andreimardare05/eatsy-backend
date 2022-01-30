package entities.roles;

import entities.types.Address;
import entities.Order;
import entities.types.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public class DeliveryPerson extends User {
    private Order currentOrder = null;
    private Address currentPosition =  new Address(0,0, "");

    @Builder
    public DeliveryPerson(String username, String password, String name, Address address, Order currentOrder, Address currentPosition) {
        //super(username, password, name, address);
        this.currentPosition = currentPosition;
        this.currentOrder = currentOrder;
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void updateOrder(String identification, OrderStatus status) throws Exception {
        Order myOrder = getCurrentOrder();
        if (myOrder.getNumber() != identification) {
            throw new Exception("Identification number not valid.");
        }
        myOrder.setStatus(status);
    }
}
