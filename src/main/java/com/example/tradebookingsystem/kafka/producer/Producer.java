package com.example.tradebookingsystem.kafka.producer;

import com.example.tradebookingsystem.model.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final NewTopic topic1;

    public Producer(KafkaTemplate<String, String> kafkaTemplate,
                    ObjectMapper objectMapper, NewTopic topic1) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.topic1 = topic1;
    }

    public void sendMessage(Trade trade) {
        try {
            String json = objectMapper.writeValueAsString(trade);
            kafkaTemplate.send("topic1", json);
            System.out.println("sendMessage  :"+ json +" to topic : "+ topic1) ;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize Trade", e);
        }
    }
}