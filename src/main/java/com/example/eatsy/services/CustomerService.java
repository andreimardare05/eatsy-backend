package com.example.eatsy.services;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.types.Restaurant;
import com.example.eatsy.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.delete(customer.get());
    }

}
