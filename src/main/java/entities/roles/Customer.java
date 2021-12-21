package entities.roles;

import entities.types.Address;
import entities.Order;
import entities.types.OrderStatus;
import entities.types.Payment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Customer extends User {
    private final Order currentOrder;
    private final Payment payment;


    @Builder
    public Customer(String username, String password, String name, Address address, Order currentOrder, Payment payment) {
        super(username, password, name, address);
        this.currentOrder = currentOrder;
        this.payment = payment;
    }

    public Order getCurrentOrder() {
        return currentOrder;
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
