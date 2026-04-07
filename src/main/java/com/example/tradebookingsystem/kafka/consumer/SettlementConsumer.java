package com.example.tradebookingsystem.kafka.consumer;

import com.example.tradebookingsystem.model.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SettlementConsumer {

    @KafkaListener(topics = "topic1", groupId = "group2")
    public void consume(String msg) {
        try {
            System.out.println("TRADE CONSUME JSON settle " + msg);
        } catch (Exception e) {
            System.err.println("Failed to process message. msg=" + msg);
            e.printStackTrace();
        }
    }
}