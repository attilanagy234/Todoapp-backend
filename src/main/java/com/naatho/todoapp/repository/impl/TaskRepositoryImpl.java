package com.naatho.todoapp.repository.impl;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.repository.CustomTaskRepository;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements CustomTaskRepository {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    LabelRepository labelRepository;

    @Override
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
}
