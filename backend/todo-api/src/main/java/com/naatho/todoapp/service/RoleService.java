package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Role;
import com.naatho.todoapp.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    Logger logger = LoggerFactory.getLogger(RoleService.class);

    public void save(Role role) {
        logger.debug("Saving role {}", role);
        roleRepository.save(role);
    }

    public List<Role> findAll() {
        logger.debug("Querying all roles");
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        logger.debug("Searching for role by id {} ", id);
        return roleRepository.findById(id);
    }

    public void deleteById(Integer id) {
        logger.debug("Attempting to delete role by id {}", id);
        roleRepository.deleteById(id);
    }

    public Role findByName(String name) {
        logger.debug("Searching for role by name {}", name);
        return roleRepository.findByName(name);
    }
}
