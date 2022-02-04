package com.example.eatsy.entities.roles;

import com.example.eatsy.observer.OrderDetails;
import com.example.eatsy.observer.models.Observer;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;

@Entity
@Table(	name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class User implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Status userStatus;
    @OneToOne
    private Role role;

    public User(String firstName, String lastName, String email, String encode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = encode;
    }

    @Override
    public void update(OrderDetails details) throws Exception {

    }
}