package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String username);
}