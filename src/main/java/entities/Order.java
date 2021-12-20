package entities;

import entities.roles.User;
import entities.types.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String number;
    private String comment;
    private OrderStatus status;
    private List<User> usersInvolved = new ArrayList<>();

    public Order(String number, String comment, OrderStatus status) {
        this.number = number;
        this.comment = comment;
        this.status = status;
    }

    /**
     * Attach a user to the list of users involved in the order.
     *
     * @param user User involved in the order.
     */
    public void registerUser(User user) {
        usersInvolved.add(user);
    }

    /**
     * Detach a user from the list of users involved in the order.
     *
     * @param user User involved in the order.
     */
    public void unregisterUser(User user) {
        usersInvolved.remove(user);
    }

    /**
     * Notifies a user from the list of users involved in the order.
     *
     * @param identification Identification string for the order.
     * @param status Status of the order.
     */
    public void notifyStatus(String identification, OrderStatus status) {
        usersInvolved.forEach(user -> {
            try {
                user.updateOrder(identification, status);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
