package com.example.eatsy.observer.models;

import com.example.eatsy.observer.OrderDetails;

public interface Observer {
    void update(OrderDetails details) throws Exception;;
}