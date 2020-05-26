package com.naatho.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.naatho.todoapp.entity.Task;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findTasksByReminderTriggeredFalseAndReminderBefore(LocalDateTime deadline);
}

