package com.example.tradebookingsystem;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TradeImpl implements TradeService {

    private TradeRepo tradeRepo;

    public TradeImpl(TradeRepo tradeRepo) {
        this.tradeRepo = tradeRepo;
    }


    @Override
    public List<Trade> getAllTrades() {
        return tradeRepo.findAll();
    }

    @Override
    public Trade getTradeByID(Long tradeId) {
        return tradeRepo.findById(tradeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Trade not found"
                ));
    }

    @Override
    public void createTrade(Trade trade) {
        tradeRepo.save(trade);
    }

    @Override
    public boolean updateTrade(Long tradeId, Trade trade) {
        Optional<Trade> existingTrade = tradeRepo.findById(tradeId);
        if (existingTrade.isPresent()) {
            Trade updatetrade = existingTrade.get();
            updatetrade.setTradeId(Long.valueOf(tradeId));
            updatetrade.setClientId(trade.getClientId());
            updatetrade.setSymbol(trade.getSymbol());
            updatetrade.setQuantity(trade.getQuantity());
            updatetrade.setPrice(trade.getPrice());
            updatetrade.setTradeType(trade.getTradeType());
            updatetrade.setStatus(trade.getStatus());
            updatetrade.setTimestamp(trade.getTimestamp());
            tradeRepo.save(updatetrade);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteTrade( Long tradeId) {
        if (tradeRepo.findById(tradeId).isPresent()){
        tradeRepo.deleteById(tradeId);
        return true;
        }
        return false;
    }
}
