package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Privilege;
import com.naatho.todoapp.repository.ReminderRepository;
import com.naatho.todoapp.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public void save(Privilege privilege) {
        privilegeRepository.save(privilege);
    }

    public List<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    public Optional<Privilege> findById(Integer id) {
        return privilegeRepository.findById(id);
    }

    public void deleteById(Integer id) {
        privilegeRepository.deleteById(id);
    }
}
