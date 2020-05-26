package com.naatho.todoapp.service;

import com.naatho.todoapp.contoller.MainController;
import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Privilege;
import com.naatho.todoapp.repository.ReminderRepository;
import com.naatho.todoapp.repository.PrivilegeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    Logger logger = LoggerFactory.getLogger(PrivilegeService.class);

    public void save(Privilege privilege) {
        logger.debug("Saving privilege {}", privilege);
        privilegeRepository.save(privilege);
    }

    public List<Privilege> findAll() {
        logger.debug("Querying all privileges");
        return privilegeRepository.findAll();
    }

    public Optional<Privilege> findById(Integer id) {
        logger.debug("Searching for privilege with id {}", id);
        return privilegeRepository.findById(id);
    }

    public void deleteById(Integer id) {
        logger.debug("Attempting to delete privilege with id {}", id);
        privilegeRepository.deleteById(id);
    }
}
