package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/projects")
public class ProjectController {
    // Dependency injection
    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping()
    public @ResponseBody
    String addNewProject (@RequestBody Project project) {
        projectRepository.save(project);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Project> getProjectByID(@PathVariable Integer id) {
        return projectRepository.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteProjectById(@PathVariable Integer id) {
        projectRepository.deleteById(id);
    }
}
