package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String username);

    @Query("select e.id from User e where e.email = :email")
    long findIdByEmail(String email);
    List<T> findAll();


}