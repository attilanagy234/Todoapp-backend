package com.naatho.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    final static Logger logger = LoggerFactory.getLogger(Task.class);


    @NotBlank
    private String name;
    private String description;

    private LocalDateTime deadline;
    @FutureOrPresent
    private LocalDateTime reminder;
    private Boolean reminderTriggered = false;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User assignee;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Project project;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<Label> labels;



    public Task(String name, User assignee, Project project) {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
    }
    public Task(String name, User assignee, Project project, String description, LocalDateTime deadline, List<Label> labels) throws Exception {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        // validate that deadline is in future
//        if (deadline.isAfter(LocalDateTime.now())) {
//            this.deadline = deadline;
//        } else {
//            logger.error("Trying to set an invalid date for a task ");
//            throw new Exception("WRONG DEADLINE");
//        }
        this.deadline = deadline;
        if (deadline != null) {
            this.reminder = deadline.minusHours(1);
        }
        this.labels = labels;


    }

    }
