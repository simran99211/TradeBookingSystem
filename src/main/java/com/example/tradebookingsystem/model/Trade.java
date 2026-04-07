package com.example.tradebookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    private Long clientId;
    private String symbol;
    private int quantity;
    private BigDecimal price;
    private TradeType tradeType;
    private TradeStatus status;
    private LocalDateTime timestamp;

    public Trade() {

    }

    public enum TradeType {
        BUY, SELL
    }
    public enum TradeStatus {
        OPEN, CLOSED, CANCELLED,VERIFIED
    }


    public Trade(Long clientId, String symbol, int quantity, TradeType tradeType, BigDecimal price, TradeStatus status, LocalDateTime timestamp) {
        this.clientId = clientId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.tradeType = tradeType;
        this.price = price;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public void setStatus(TradeStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
