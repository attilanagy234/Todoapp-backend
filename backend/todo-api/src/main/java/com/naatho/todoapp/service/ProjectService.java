package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.repository.ProjectRepository;
import com.naatho.todoapp.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Integer id) {
        return projectRepository.findById(id);
    }

    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }
}
