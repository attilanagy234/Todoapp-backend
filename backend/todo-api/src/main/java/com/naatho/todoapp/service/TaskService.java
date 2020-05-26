package com.naatho.todoapp.service;

import com.naatho.todoapp.contoller.MainController;
import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TaskService.class);

    public void addLabelToTask(String labelId, Integer taskId) throws Exception {
        Optional<Task> t = taskRepository.findById(taskId);
        Optional<Label> l = labelRepository.findById(labelId);
        if (t.isEmpty() || l.isEmpty()) {
            logger.trace("Task or label is non-existent, t: {}, l: {}", t, l);
            // TODO: proper exception handling
            throw new Exception();
        }

        t.get().getLabels().add(l.get());
        taskRepository.save(t.get());
        logger.debug("Added label {} to task {}", l.get().getName(), t.get().getName());
    }

    public void save(Task task) {
        logger.debug("Saving task {}", task);
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        logger.debug("Querying all tasks");
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Integer id) {
        logger.debug("Searching for task by id {}", id);
        return taskRepository.findById(id);
    }

    public void deleteById(Integer id) {
        logger.debug("Attempting to delete task with id {}", id);
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
