package com.naatho.todoapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @ManyToMany
    private List<User> members;

    @OneToMany(fetch=FetchType.LAZY)
    private List<Task> tasks;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
