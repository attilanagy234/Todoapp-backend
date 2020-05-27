package com.naatho.todoapp.notifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoNotifierApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TodoNotifierApplication.class, args);
        Thread.sleep(1000000000);
    }
}
