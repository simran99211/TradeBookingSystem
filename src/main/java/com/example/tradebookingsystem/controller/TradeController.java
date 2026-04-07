package com.example.tradebookingsystem.controller;

import com.example.tradebookingsystem.kafka.producer.Producer;
import com.example.tradebookingsystem.model.Trade;
import com.example.tradebookingsystem.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    Producer producer;

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }


    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades() {
        producer.sendMessage("Trade created successfully and sended to producer successfully");
        return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.OK);
    }

    @GetMapping("/{tradeId}")
    public ResponseEntity<Trade> getTradeByID(@PathVariable Long tradeId) {
        return new ResponseEntity<>(tradeService.getTradeByID(tradeId),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createTrade(@RequestBody Trade trade) {
        tradeService.createTrade(trade);
        return new ResponseEntity<>("Trade created successfully", HttpStatus.CREATED);
    }


    @PutMapping( "/{tradeId}")
    public ResponseEntity<String> updateTrade(@PathVariable Long tradeId, @RequestBody Trade trade) {
        tradeService.updateTrade(tradeId, trade);
        return new ResponseEntity<>("Trade updated successfully", HttpStatus.OK);
    }


    @DeleteMapping("/{tradeId}")
    public ResponseEntity<String> deleteTrade(@PathVariable Long tradeId) {
        boolean isDeleted = tradeService.deleteTrade(tradeId);
        if (isDeleted) {
         return new ResponseEntity<>("Trade deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Trade not found", HttpStatus.NOT_FOUND);
    }

}
