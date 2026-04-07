package com.example.tradebookingsystem.service;

import com.example.tradebookingsystem.model.Trade;

import java.util.List;

public interface TradeService {

    List<Trade> getAllTrades();

    Trade getTradeByID(Long tradeId);
    void createTrade(Trade trade);
    boolean updateTrade(Long tradeId, Trade trade);
    boolean deleteTrade(Long tradeId);
}
