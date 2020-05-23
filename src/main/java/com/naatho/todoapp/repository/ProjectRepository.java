package com.naatho.todoapp.repository;


import org.springframework.data.repository.CrudRepository;

import com.naatho.todoapp.entity.Project;


public interface ProjectRepository extends CrudRepository<Project, Integer> {

}