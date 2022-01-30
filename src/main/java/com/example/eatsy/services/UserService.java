package com.example.eatsy.services;

import com.example.eatsy.dto.SignupRequest;
import com.example.eatsy.entities.roles.ERole;
import com.example.eatsy.entities.roles.Role;
import com.example.eatsy.entities.roles.User;
import com.example.eatsy.repositories.RoleRepository;
import com.example.eatsy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User save(SignupRequest signUpRequest) {

        // Create new user's account
        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        String strRole = signUpRequest.getRole();

        switch (strRole) {
            case "ROLE_ADMIN":
                Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setRole(adminRole);

                break;
            case "ROLE_RESTAURANT_MANAGER":
                Role managerRole = roleRepository.findByName(ERole.ROLE_RESTAURANT_MANAGER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setRole(managerRole);

                break;
            case "ROLE_DELIVERY":
                Role deliveryRole = roleRepository.findByName(ERole.ROLE_DELIVERY_MAN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setRole(deliveryRole);

                break;
            default:
                Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setRole(userRole);
        };
        return userRepository.save(user);
    }
}
