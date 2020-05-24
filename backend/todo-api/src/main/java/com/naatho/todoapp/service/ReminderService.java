package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    ReminderRepository reminderRepository;

    public void save(Project project) {
        reminderRepository.save(project);
    }

    public Iterable<Project> findAll() {
        return reminderRepository.findAll();
    }

    public Optional<Project> findById(Integer id) {
        return reminderRepository.findById(id);
    }

    public void deleteById(Integer id) {
        reminderRepository.deleteById(id);
    }
}
