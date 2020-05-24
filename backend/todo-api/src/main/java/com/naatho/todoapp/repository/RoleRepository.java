package com.naatho.todoapp.repository;

import com.naatho.todoapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
