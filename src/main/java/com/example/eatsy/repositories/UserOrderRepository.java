package com.example.eatsy.repositories;

import com.example.eatsy.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends CrudRepository<UserOrder, Long> {

    @Query("select o from UserOrder o where o.restaurant.id = :id")
    List<UserOrder> findAllByRestaurant(long id);

    @Query("select o from UserOrder o where o.customer.id = :id")
    List<UserOrder> findAllByUser(long id);

    List<UserOrder> findAll();

}
