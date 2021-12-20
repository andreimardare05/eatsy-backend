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

    public void notifyStatus(OrderStatus status) {
        usersInvolved.forEach(user -> {
            user.updateOrder(status);
        });
    }

    public void registerUser(User user) {
        usersInvolved.add(user);
    }

    public void unregisterUser(User user) {
        usersInvolved.remove(user);
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
