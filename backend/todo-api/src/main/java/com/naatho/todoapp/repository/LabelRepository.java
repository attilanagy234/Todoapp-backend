package com.naatho.todoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.naatho.todoapp.entity.Label;


public interface LabelRepository extends JpaRepository<Label, String> {
}

