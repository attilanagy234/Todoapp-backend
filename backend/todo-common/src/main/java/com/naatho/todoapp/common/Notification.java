package com.naatho.todoapp.common;

public class Notification {
    String username;
    String email;
    String text;
    String taskName;

    public Notification(String username, String email, String taskName, String text) {
        this.username = username;
        this.email = email;
        this.text = text;
        this.taskName = taskName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTaskName() {
        return taskName;
    }
    @Override
    public String toString() {
        return "Notification(email=" + this.email + ")";
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}

