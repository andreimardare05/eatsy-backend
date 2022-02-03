package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String username);

    @Query("select e.id from User e where e.email = :email")
    long findIdByEmail(String email);
}