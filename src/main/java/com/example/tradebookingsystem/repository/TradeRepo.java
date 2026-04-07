package com.example.tradebookingsystem.repository;

import com.example.tradebookingsystem.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepo extends JpaRepository<Trade, Long> {
}
