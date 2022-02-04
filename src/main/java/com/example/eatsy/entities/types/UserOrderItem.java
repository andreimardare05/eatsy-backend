package com.example.eatsy.entities.types;

import com.example.eatsy.entities.UserOrder;
import com.example.eatsy.observer.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="menu_item_id")
    private long menuItemId;
    private int quantity;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "user_order_id", insertable = false, updatable = false)
    private UserOrder userOrder;
}
