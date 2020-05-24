package com.naatho.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.naatho.todoapp.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {


}

