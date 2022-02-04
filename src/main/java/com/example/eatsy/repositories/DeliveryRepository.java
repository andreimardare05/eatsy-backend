package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.DeliveryPerson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends UserRepository<DeliveryPerson> {
    List<DeliveryPerson> findAll();
}
