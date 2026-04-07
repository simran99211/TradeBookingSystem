package com.example.tradebookingsystem.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "topic1", groupId = "group1")
    public void consume(String msg) {
        try {
            System.out.println("TRADE CONSUME notification " + msg);
        } catch (Exception e) {
            System.err.println("Failed to process message. msg=" + msg);}
    }
}