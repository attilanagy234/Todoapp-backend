package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/tasks")
public class TaskController {

    // Dependency injection
    @Autowired
    private TaskService taskService;

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Task> addNewTask (@Valid @RequestBody Task task) {
        taskService.save(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public @ResponseBody Iterable<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Task> getTaskByID(@PathVariable Integer id) {
        Optional<Task> foundTask = taskService.findById(id);
        if (foundTask == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(foundTask.get());
        }
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Task> deleteTaskById(@PathVariable Integer id) {
        Optional<Task> foundTask = taskService.findById(id);

        if (foundTask == null) {
            return ResponseEntity.notFound().build();
        } else {
            taskService.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping(path="/{taskId}/label/{labelId}")
    public void addLabelToTask(@PathVariable Integer taskId, @PathVariable String labelId) throws Exception {
        taskService.addLabelToTask(labelId, taskId);
    }

    @PutMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) throws Exception {
        Optional<Task> foundTask = taskService.findById(id);
        if (foundTask == null) {
            return ResponseEntity.notFound().build();
        } else {
            taskService.updateTask(id, task);
            return ResponseEntity.ok().build();
        }
    }
}
