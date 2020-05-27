package com.naatho.todoapp.notifier;

import com.naatho.todoapp.common.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Notifier {

    Logger logger = LoggerFactory.getLogger(Notifier.class);

    @Autowired
    MailSenderService mailSenderService;

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Notification notification) {
        logger.info("Received Messasge in group foo: " + notification);
        String to = notification.getEmail();
        String subject = "TASK REMINDER";
        String body = notification.getText();

        mailSenderService.sendMail(to, subject, body);
    }
}
