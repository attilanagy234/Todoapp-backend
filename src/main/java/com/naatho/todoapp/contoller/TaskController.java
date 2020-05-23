package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/tasks")
public class TaskController {

    // Dependency injection
    @Autowired
    private TaskService taskService;

    @PostMapping()
    public @ResponseBody
    String addNewTask (@RequestBody Task task) {
        taskService.save(task);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Task> getTaskByID(@PathVariable Integer id) {
        return taskService.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteTaskById(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @PutMapping(path="/{taskId}/label/{labelId}")
    public void addLabelToTask(@PathVariable Integer taskId, @PathVariable String labelId) throws Exception {
        taskService.addLabelToTask(labelId, taskId);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody
    Optional<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) throws Exception {
        return taskService.updateTask(id, task);
    }
}
