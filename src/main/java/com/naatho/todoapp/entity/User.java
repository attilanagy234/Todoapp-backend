package com.naatho.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @ManyToMany
    private Set<Project> projects;
}