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
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "restaurant manager":
                        Role modRole = roleRepository.findByName(ERole.ROLE_RESTAURANT_MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    case "delivery man":
                        Role deliveryRole = roleRepository.findByName(ERole.ROLE_DELIVERY_MAN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(deliveryRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }
}
