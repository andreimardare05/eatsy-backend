package com.example.eatsy.repositories;

import com.example.eatsy.entities.types.MenuItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository  extends CrudRepository<MenuItem, Long> {

    @Query(value = "select m from MenuItem m where m.restaurant.id = :restaurantId and m.name =:name" )
    MenuItem getMenuItem(String name, long restaurantId);
}
