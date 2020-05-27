package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/projects")
public class ProjectController {

    // Dependency injection
    @Autowired
    private ProjectService projectService;

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Label> addNewProject (@Valid @RequestBody Project project) {
        projectService.save(project);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public @ResponseBody Iterable<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Project> getProjectByID(@PathVariable Integer id) {
        Optional<Project> foundProject = projectService.findById(id);

        if (foundProject.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(foundProject.get());
        }
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Project> deleteProjectById(@PathVariable Integer id) {
        Optional<Project> foundProject = projectService.findById(id);
        if (foundProject == null) {
            return ResponseEntity.notFound().build();
        } else {
            projectService.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
