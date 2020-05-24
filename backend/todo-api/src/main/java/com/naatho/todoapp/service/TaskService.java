package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    LabelRepository labelRepository;

    public void addLabelToTask(String labelId, Integer taskId) throws Exception {
        Optional<Task> t = taskRepository.findById(taskId);
        Optional<Label> l = labelRepository.findById(labelId);
        if (t.isEmpty() || l.isEmpty()) {
            // TODO: proper exception handling
            throw new Exception();
        }

        t.get().getLabels().add(l.get());
        taskRepository.save(t.get());
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Integer id) {
        return taskRepository.findById(id);
    }

    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> updateTask(Integer id, Task task) throws Exception {
//        //TODO: Gotta get the actual user here!!!
//        User user = new User();
//
//        //TODO: Verify that this actually works:
//        // ? : are the equals/hashcode methods implemented correctly
//        if (!task.getProject().getUsers().contains(user)) {
//            //TODO: proper exception handling
//            throw new Exception("Unauthorized");
//        }
//        Optional<Task> foundTask = taskRepository.findById(id);
//        foundTask.get().setDescription(task.getDescription());
//        foundTask.get().setName(task.getName());
//        taskRepository.save(foundTask.get());
//        return foundTask;
        return Optional.empty();
    }
}
