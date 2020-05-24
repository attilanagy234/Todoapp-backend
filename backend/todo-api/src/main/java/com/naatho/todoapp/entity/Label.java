package com.naatho.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Label {
    @Id
    private String name;
    private String displayValue;

    @ManyToMany
    private Set<Task> tasks;
}