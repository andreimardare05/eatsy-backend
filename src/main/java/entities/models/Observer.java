package entities.models;

import entities.OrderDetails;

public interface Observer {
    void update(OrderDetails details) throws Exception;;
}