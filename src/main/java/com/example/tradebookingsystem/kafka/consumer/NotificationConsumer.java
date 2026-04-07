package com.example.tradebookingsystem.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class NotificationConsumer {


@KafkaListener(topics = "topic1", groupId = "group1")
public void consume(String msg){
    System.out.println(msg);
}
}