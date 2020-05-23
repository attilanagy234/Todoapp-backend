package com.naatho.todoapp.repository;

public interface CustomTaskRepository {
    public void addLabelToTask(String labelId, Integer taskId);
}
