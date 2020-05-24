package com.naatho.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @ManyToMany
    private Set<Project> projects;

    @ManyToMany
    private List<Role> roles;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {}

}