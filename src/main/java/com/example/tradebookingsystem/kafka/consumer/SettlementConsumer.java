package com.example.tradebookingsystem.kafka.consumer;

import com.example.tradebookingsystem.model.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SettlementConsumer {

    private final ObjectMapper objectMapper;

    public SettlementConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "topic1", groupId = "group2")
    public void consume(String msg) {
        try {
            Trade trade = objectMapper.readValue(msg, Trade.class);
            String json = objectMapper.writeValueAsString(trade);
            System.out.println("TRADE CONSUME JSON settle " + json);
        } catch (Exception e) {
            System.err.println("Failed to process message. msg=" + msg);
            e.printStackTrace();
        }
    }
}