package com.example.emailsender;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final EmailService emailService;

    @Autowired
    public RabbitMQConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "javatask")
    public void receiveMessage(String message) {
        emailService.sendEmail("mrtdrn4@gmail.com", "message received", message);

    }
}
