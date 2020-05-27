package com.naatho.todoapp.notifier;

import com.naatho.todoapp.common.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Notifier {

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Notification notification) {
        System.out.println("Received Messasge in group foo: " + notification);
    }
}
