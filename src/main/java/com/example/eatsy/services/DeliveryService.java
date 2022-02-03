package com.example.eatsy.services;

import com.example.eatsy.entities.roles.Customer;
import com.example.eatsy.entities.roles.DeliveryPerson;
import com.example.eatsy.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    public DeliveryRepository deliveryRepository;

    public List<DeliveryPerson> getAllDelivery() {
        return deliveryRepository.findAll();
    }
}
