package com.naatho.todoapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Label {
    @Id
    private String name;
    @NotBlank
    private String displayValue;

    @ManyToMany
    private List<Task> tasks;

    public Label(String name, String displayValue) {
        this.name = name;
        this.displayValue = displayValue;
    }
}