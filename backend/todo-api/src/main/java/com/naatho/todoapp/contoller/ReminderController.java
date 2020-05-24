package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/reminders")
public class ReminderController {

    // Dependency injection
    @Autowired
    private ReminderService reminderService;

    @PostMapping()
    public @ResponseBody
    String addNewProject (@RequestBody Project project) {
        reminderService.save(project);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Project> getAllProjects() {
        return reminderService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Project> getProjectByID(@PathVariable Integer id) {
        return reminderService.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteProjectById(@PathVariable Integer id) {
        reminderService.deleteById(id);
    }
}
