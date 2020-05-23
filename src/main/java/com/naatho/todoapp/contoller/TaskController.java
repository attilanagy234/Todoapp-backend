package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/tasks")
public class TaskController {
    // Dependency injection
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping()
    public @ResponseBody
    String addNewTask (@RequestBody Task task) {
        taskRepository.save(task);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Task> getTaskByID(@PathVariable Integer id) {
        return taskRepository.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteTaskById(@PathVariable Integer id) {
        taskRepository.deleteById(id);
    }

    @PutMapping(path="/{taskId}/label/{labelId}")
    public void addLabelToTask(@PathVariable Integer taskId, @PathVariable String labelId) throws Exception {
        taskRepository.addLabelToTask(labelId, taskId);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody
    Optional<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        Optional<Task> foundTask = taskRepository.findById(id);
        foundTask.get().setDescription(task.getDescription());
        foundTask.get().setName(task.getName());
        taskRepository.save(foundTask.get());
        return foundTask;
    }
}
