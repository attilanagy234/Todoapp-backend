package com.naatho.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Date deadline;

    @NotNull
    @ManyToOne
    private Project project;

    @ManyToMany
    private Set<Label> labels;

    @OneToMany
    private Set<Reminder> reminders;
}
