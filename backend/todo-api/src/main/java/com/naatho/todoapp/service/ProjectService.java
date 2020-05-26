package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public void save(Project project) {
        logger.debug("Saving project ", project);
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        logger.debug("Querying all projects");
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Integer id) {
        logger.debug("Searching for project by id {}", id);
        return projectRepository.findById(id);
    }

    public void deleteById(Integer id) {
        logger.debug("Attempting to delete project with id {}", id);
        projectRepository.deleteById(id);
    }
}
