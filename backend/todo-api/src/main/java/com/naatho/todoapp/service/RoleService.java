package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Role;
import com.naatho.todoapp.repository.ReminderRepository;
import com.naatho.todoapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
