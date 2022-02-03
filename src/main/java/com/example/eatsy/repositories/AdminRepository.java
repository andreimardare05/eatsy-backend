package com.example.eatsy.repositories;

import com.example.eatsy.entities.roles.Admin;
import com.example.eatsy.entities.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends UserRepository {

}