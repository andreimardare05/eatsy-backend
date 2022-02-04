package com.example.eatsy.services;

import com.example.eatsy.config.JwtUtils;
import com.example.eatsy.dto.SignupRequest;
import com.example.eatsy.dto.UserDto;
import com.example.eatsy.entities.roles.*;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.repositories.AdminRepository;
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
    private UserRepository<User> userRepository;

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User updateUser(UserDto userDto) {
        User userFound = userRepository.findById(userDto.getId());
        if (userFound == null)
            throw new RuntimeException("User not found");

        User updatedUser = userFound;
        updatedUser.setEmail(userDto.getEmail());
        updatedUser.setUserStatus(userDto.getUserStatus());
        updatedUser.setFirstName(userDto.getFirstName());
        updatedUser.setLastName(userDto.getLastName());

        return userRepository.save(updatedUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(long id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }

    public User save(SignupRequest signUpRequest) {

        String strRole = signUpRequest.getRole();

        switch (strRole) {
            case "ROLE_ADMIN":
                Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                Admin admin = Admin.builder()
                        .firstName(signUpRequest.getFirstName())
                        .lastName(signUpRequest.getLastName())
                        .email(signUpRequest.getEmail())
                        .password(encoder.encode(signUpRequest.getPassword()))
                        .role(adminRole)
                        .build();
                return userRepository.save(admin);

            case "ROLE_RESTAURANT_MANAGER":
                Role managerRole = roleRepository.findByName(ERole.ROLE_RESTAURANT_MANAGER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                RestaurantManager restaurantManager = RestaurantManager.builder()
                        .firstName(signUpRequest.getFirstName())
                        .lastName(signUpRequest.getLastName())
                        .email(signUpRequest.getEmail())
                        .password(encoder.encode(signUpRequest.getPassword()))
                        .role(managerRole)
                        .userStatus(Status.PENDING)
                        .build();
                return userRepository.save(restaurantManager);

            case "ROLE_DELIVERY":
                Role deliveryRole = roleRepository.findByName(ERole.ROLE_DELIVERY_MAN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                DeliveryPerson deliveryPerson  = DeliveryPerson.builder()
                        .firstName(signUpRequest.getFirstName())
                        .lastName(signUpRequest.getLastName())
                        .email(signUpRequest.getEmail())
                        .password(encoder.encode(signUpRequest.getPassword()))
                        .role(deliveryRole)
                        .userStatus(Status.PENDING)
                        .build();
                return userRepository.save(deliveryPerson);

            default:
                Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                Customer customer  = Customer.builder()
                        .firstName(signUpRequest.getFirstName())
                        .lastName(signUpRequest.getLastName())
                        .email(signUpRequest.getEmail())
                        .password(encoder.encode(signUpRequest.getPassword()))
                        .role(customerRole)
                        .build();
                return userRepository.save(customer);
        }
    }
}
