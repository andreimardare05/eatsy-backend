package com.example.eatsy.entities.roles;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(	name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToOne
    private Role role;

    public User(String firstName, String lastName, String email, String encode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = encode;
    }
}