package com.naatho.todoapp.utils;

import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Lazy(false)
public class ReminderScheduler {

    @Autowired
    TaskService taskService;

    Logger logger = LoggerFactory.getLogger(ReminderScheduler.class);

    @Transactional
    @Scheduled(fixedRate = 1000)
    public void scheduleTask() {
        List<Task> tasksToRemind = taskService.getTasksToRemind();
        for (Task task : tasksToRemind) {
             logger.info("Found the following tasks to send reminders for name: {} id: {}", task.getName(), task.getId());
             //TODO: Send to queue
            task.setReminderTriggered(true);
            task.setReminder(null);
        }
        taskService.saveAll(tasksToRemind);

    }
}
