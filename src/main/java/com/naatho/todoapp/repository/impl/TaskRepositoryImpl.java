package com.naatho.todoapp.repository.impl;

import com.naatho.todoapp.repository.CustomTaskRepository;
import com.naatho.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl implements CustomTaskRepository {

    @Override
    public void addLabelToTask(String labelId, Integer taskId ) {
        
    }
}
