package com.example.eatsy.repositories;
import com.example.eatsy.entities.roles.ERole;
import com.example.eatsy.entities.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}