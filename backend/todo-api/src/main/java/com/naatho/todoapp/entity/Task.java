package com.naatho.todoapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;
    private String description;
    private Date deadline;
    @NotNull

    @ManyToOne(fetch=FetchType.EAGER)
    private User assignee;

    @NotNull
    @ManyToOne(fetch=FetchType.EAGER)
    private Project project;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Label> labels;

    @OneToMany(fetch=FetchType.LAZY)
    private List<Reminder> reminders;


    public Task(String name, User assignee, Project project) {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
    }
    public Task(String name, User assignee, Project project, String description, Date deadline, List<Label> labels) {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        this.deadline = deadline;
        this.labels = labels;


    }

    }
