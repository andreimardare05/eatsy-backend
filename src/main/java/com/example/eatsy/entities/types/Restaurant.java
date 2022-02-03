package com.example.eatsy.entities.types;

import com.example.eatsy.entities.UserOrder;
import com.example.eatsy.entities.roles.RestaurantManager;
import com.example.eatsy.entities.roles.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
    private String description;
    private String contact;
    private Integer openingTime;
    private Integer closingTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<UserOrder> userOrders;

    @OneToMany(cascade=CascadeType.ALL)
    private List<MenuItem> menuItems;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "restaurant")
    private RestaurantManager restaurantManager;

}
