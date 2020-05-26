package com.naatho.todoapp.utils;

import com.naatho.todoapp.common.Notification;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.service.TaskService;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
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

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Notification> kafkaTemplate;

    @Transactional
    @Scheduled(fixedRate = 1000)
    public void scheduleTask() {
        List<Task> tasksToRemind = taskService.getTasksToRemind();
        for (Task task : tasksToRemind) {
            logger.info("Found the following tasks to send reminders for name: {} id: {}", task.getName(), task.getId());
            Notification notification = new Notification(task.getAssignee().getName(), task.getAssignee().getEmail(), task.getName(), "DO YOU TASK BRO!");
            kafkaTemplate.send(topic, notification);
            task.setReminderTriggered(true);
            task.setReminder(null);
        }
        taskService.saveAll(tasksToRemind);

    }
}
