package com.example.demo.repositories;

import com.example.demo.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepsoitory extends CrudRepository<Role, Integer> {
}
