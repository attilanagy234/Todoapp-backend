package com.naatho.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date reminderDate;

    private String reminderMessage;

    @ManyToOne(fetch=FetchType.LAZY)
    private Task task;
}