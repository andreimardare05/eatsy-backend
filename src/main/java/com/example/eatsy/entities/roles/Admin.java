package com.example.eatsy.entities.roles;

import com.example.eatsy.entities.types.Address;
import com.example.eatsy.entities.types.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
@Getter
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "admin_id")
@DiscriminatorValue("admin")
@Entity
@SuperBuilder
public class Admin extends User {

    /*@Builder
    public Admin(String username, String password, String name, String email, String phone, List<Order> orders) {
        super(username, password, name, email, phone);
        this.orders = orders;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void updateOrder(String identification, OrderStatus status) {
        Stream<Order> myOrder = this.getOrders().stream().filter(order -> identification == order.getNumber());
        myOrder.findFirst().get().setStatus(status);
    }*/
}
