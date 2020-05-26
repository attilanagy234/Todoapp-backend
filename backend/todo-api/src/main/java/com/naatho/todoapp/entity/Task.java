package com.naatho.todoapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
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
    private Date deadline;
    private Boolean reminderTriggered = false;

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
    public Task(String name, User assignee, Project project, String description, Date deadline, List<Label> labels) throws Exception {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        // validate that deadline is in future
        Date now = new Date(System.currentTimeMillis());
        if (deadline.compareTo(now) > 0) {
            // compareTo: Returns:
            //the value 0 if the argument Date is equal to this Date;
            // a value less than 0 if this Date is before the Date argument;
            // a value greater than 0 if this Date is after the Date argument.
            this.deadline = deadline;
        } else {
            logger.error("Trying to set an invalid date for a task ");
            throw new Exception("WRONG DEADLINE");
        }
        this.labels = labels;


    }

    }
