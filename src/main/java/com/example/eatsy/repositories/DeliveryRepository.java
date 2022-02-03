package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.DeliveryPerson;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends UserRepository<DeliveryPerson> {

}
