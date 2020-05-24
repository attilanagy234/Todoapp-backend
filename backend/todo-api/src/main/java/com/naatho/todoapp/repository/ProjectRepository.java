package com.naatho.todoapp.repository;

import com.naatho.todoapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

}