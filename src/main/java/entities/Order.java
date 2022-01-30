package entities;

import entities.models.Observer;
import entities.models.Subject;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private OrderDetails details;
    private List<Observer> usersInvolved = new ArrayList<>();

    public Order(OrderDetails details, List<Observer> usersInvolved) {
        this.details = details;
        this.usersInvolved = usersInvolved;
    }

    /**
     * Attach a user to the list of users involved in the order.
     *
     * @param user User involved in the order.
     */
    @Override
    public void registerObserver(Observer user) {
        usersInvolved.add(user);
    }

    /**
     * Detach a user from the list of users involved in the order.
     *
     * @param user User involved in the order.
     */
    @Override
    public void unregisterObserver(Observer user) {
        usersInvolved.remove(user);
    }

    /**
     * Notifies a user from the list of users involved in the order.
     */
    @Override
    public void notifyObservers() {
        usersInvolved.forEach(user -> {
            try {
                user.update(details);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public OrderDetails getDetails() {
        return details;
    }

    public void setDetails(OrderDetails details) {
        this.details = details;
    }

    public List<Observer> getUsersInvolved() {
        return usersInvolved;
    }

    public void setUsersInvolved(List<Observer> usersInvolved) {
        this.usersInvolved = usersInvolved;
    }
}
